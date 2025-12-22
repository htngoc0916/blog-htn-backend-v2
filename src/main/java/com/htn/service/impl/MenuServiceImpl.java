package com.htn.service.impl;

import com.htn.dto.MenuDTO;
import com.htn.dto.MenuResponseDTO;
import com.htn.entity.Menu;
import com.htn.entity.MenuPermissionConfig;
import com.htn.entity.Permission;
import com.htn.exception.GlobalException;
import com.htn.exception.NotFoundException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.MenuMapper;
import com.htn.mapper.mybatis.MenuMbtMapper;
import com.htn.module.TreeModule;
import com.htn.repository.MenuRepository;
import com.htn.repository.PermissionRepository;
import com.htn.service.MenuService;
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
        return menuMbtMapper.getMenuById(menuId).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND_WITH, "MenuId="+menuId))
        );
    }

    @Override
    public List<MenuResponseDTO> getMenus() {
        List<Menu> allMenus = menuRepository.findAll();
        List<MenuResponseDTO> responseDTO = menuMapper.toResponseDto(allMenus);
        return TreeModule.buildTree(responseDTO);
    }

    @Override
    public List<MenuResponseDTO> getMenuByCode(String menuCode) {
        List<Menu> allMenus = menuRepository.findByMenuCodeAndUsedYnOrderByMenuOrdAsc(menuCode, "Y");
        List<MenuResponseDTO> responseDTO = menuMapper.toResponseDto(allMenus);
        return TreeModule.buildTree(responseDTO);
    }

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
}
