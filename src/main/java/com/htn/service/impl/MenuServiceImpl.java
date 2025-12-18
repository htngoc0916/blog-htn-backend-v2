package com.htn.service.impl;

import com.htn.dto.MenuDTO;
import com.htn.dto.MenuResponseDTO;
import com.htn.entity.Menu;
import com.htn.exception.GlobalException;
import com.htn.exception.NotFoundException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.MenuMapper;
import com.htn.repository.MenuRepository;
import com.htn.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private LocalizationService i18n;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu getMenuById(Long menuId) {
        return menuRepository.findById(menuId).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND))
        );
    }

    @Override
    public List<MenuResponseDTO> getMenus() {
        List<Menu> allMenus = menuRepository.findAll();
        return handleTreeMenu(allMenus);
    }

    @Override
    public List<MenuResponseDTO> getMenuByCode(String menuCode) {
        List<Menu> allMenus = menuRepository.findByMenuCodeAndUsedYnOrderByMenuOrdAsc(menuCode, "Y");
        return handleTreeMenu(allMenus);
    }

    @Override
    public Menu addMenu(MenuDTO menuDTO) {
        menuRepository.findByMenuCode(menuDTO.getMenuCode()).ifPresent(menu -> {
            throw new GlobalException(i18n.translate(CommonMessages.COMMON_DATA_EXISTED));
        });

        Menu menu = menuMapper.toEntity(menuDTO);
        return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu(Long menuId, MenuDTO menuDTO) {
        Menu menu = getMenuById(menuId);
        menuMapper.updateFromDto(menuDTO, menu);
        return menuRepository.save(menu);
    }

    @Override
    public boolean deleteMenu(Long menuId) {
        Menu menu = getMenuById(menuId);
        menuRepository.delete(menu);
        return true;
    }

    //tìm các root menus
    private List<Menu> findRootMenus(List<Menu> allMenus) {
        return allMenus.stream().filter(menu -> menu.getParentCd() == null || menu.getParentCd().isEmpty()).toList();
    }

    //tìm các child menus
    private List<Menu> findChildMenus(List<Menu> allMenus, String parentCd) {
        return allMenus.stream().filter(menu -> menu.getParentCd().equals(parentCd)).toList();
    }

    //xứ lý treeMenu
    private List<MenuResponseDTO>handleTreeMenu(List<Menu> allMenus) {
        //lay ra cac root menus
        List<Menu> rootMenus = findRootMenus(allMenus);

        //tìm các childMenus từ rootMenu
        return  rootMenus.stream()
                .map(root -> buildMenuNode(root, allMenus))
                .toList();
    }

    private MenuResponseDTO buildMenuNode(Menu menu, List<Menu> allMenus) {
        // Tìm menu con
        List<Menu> childMenus = findChildMenus(allMenus, menu.getMenuCode());

        // Build DTO cho node hiện tại
        MenuResponseDTO dto = menuMapper.toResponseDto(menu);

        // Nếu có con → xử lý đệ quy
        if (!childMenus.isEmpty()) {
            List<MenuResponseDTO> childDTOs = childMenus.stream()
                    .map(child -> buildMenuNode(child, allMenus))
                    .toList();
            dto.setChildren(childDTOs);
        }

        return dto;
    }
}
