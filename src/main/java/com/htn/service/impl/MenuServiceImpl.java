package com.htn.service.impl;

import com.htn.dto.MenuDTO;
import com.htn.dto.MenuResponseDTO;
import com.htn.dto.PermissionConfigDTO;
import com.htn.entity.Menu;
import com.htn.entity.MenuPermissionConfig;
import com.htn.entity.Permission;
import com.htn.exception.GlobalException;
import com.htn.exception.NotFoundException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.MenuMapper;
import com.htn.mapper.mybatis.MenuMbtMapper;
import com.htn.repository.MenuRepository;
import com.htn.repository.PermissionRepository;
import com.htn.service.MenuService;
import com.htn.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private LocalizationService i18n;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuMbtMapper menuMbtMapper;

    @Override
    public MenuResponseDTO getMenuById(Long menuId) {
        MenuResponseDTO menuResponseDTO = menuMbtMapper.getMenuById(menuId).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND_WITH, "MenuId="+menuId))
        );

        return menuResponseDTO;
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

//    @Override
//    public MenuResponseDTO addMenu(MenuDTO menuDTO) {
//        menuRepository.findByMenuCode(menuDTO.getMenuCode()).ifPresent(menu -> {
//            throw new GlobalException(i18n.translate(CommonMessages.COMMON_DATA_EXISTED));
//        });
//
//        Menu menu = menuMapper.toEntity(menuDTO);
//        //set permission for menu
//        List<MenuPermissionConfig> configs = menuDTO.getPermissions().stream().map(
//                permissionCd -> {
//                    Permission permission = permissionService.getPermissionByCd(permissionCd);
//                    return  MenuPermissionConfig.builder()
//                            .menu(menu)
//                            .permission(permission)
//                            .build();
//                }
//        ).toList();
//        menu.setPermissionConfigs(configs);
//
//        Menu resultMenu = menuRepository.save(menu);
//        List<MenuPermissionConfig> menuPermissionConfigs = resultMenu.getPermissionConfigs();
//
//        MenuResponseDTO menuResponseDTO = menuMapper.toResponseDto(resultMenu);
//        List<PermissionConfigDTO> responsePermissionConfigs = menuPermissionConfigs.stream().map(
//                item -> {
//                    return PermissionConfigDTO.builder()
//                            .permissionCd(item.getPermission().getPermissionCd())
//                            .permissionName(item.getPermission().getPermissionNm())
//                            .description(item.getDescription())
//                            .build();
//                }
//        ).toList();
//
//        menuResponseDTO.setPermissions(responsePermissionConfigs);
//
//        return menuResponseDTO;
//    }


    @Override
    @Transactional
    public MenuResponseDTO addMenu(MenuDTO menuDTO) {
        menuRepository.findByMenuCode(menuDTO.getMenuCode()).ifPresent(menu -> {
            throw new GlobalException(i18n.translate(CommonMessages.COMMON_DATA_EXISTED));
        });

        Menu menu = menuMapper.toEntity(menuDTO);
        // load permissions 1 lần
        Map<String, Permission> permissionMap = permissionRepository.findByPermissionCdIn(menuDTO.getPermissions())
                .stream()
                .collect(Collectors.toMap(Permission::getPermissionCd, Function.identity()));
        //set permission for menu
        List<MenuPermissionConfig> configs = menuDTO.getPermissions().stream()
                .map(cd -> MenuPermissionConfig.builder()
                                .menu(menu)
                                .permission(permissionMap.get(cd))
                                .build())
                .toList();
        menu.setPermissionConfigs(configs);
        //lưu
        Menu savedMenu = menuRepository.save(menu);

        return menuMapper.toResponseDto(savedMenu);
    }

    @Override
    public MenuResponseDTO updateMenu(Long menuId, MenuDTO menuDTO) {
//        Menu menu = getMenuById(menuId);
//        menuMapper.updateFromDto(menuDTO, menu);
//        return menuRepository.save(menu);
        return null;
    }

    @Override
    public boolean deleteMenu(Long menuId) {
//        Menu menu = getMenuById(menuId);
//        menuRepository.delete(menu);

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
