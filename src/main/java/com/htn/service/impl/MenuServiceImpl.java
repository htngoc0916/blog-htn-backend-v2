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


    @Override
    public MenuResponseDTO getMenuByCode(String menuCode) {
        Menu menu = menuRepository.findByMenuCode(menuCode).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND))
        );
        return menuMapper.toResponseDto(menu);
    }

    @Override
    public MenuResponseDTO getMenuById(Long menuId) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND))
        );
        return menuMapper.toResponseDto(menu);
    }

    @Override
    public List<MenuResponseDTO> getMenus() {
        List<Menu> allMenus = menuRepository.findAll();
        List<MenuResponseDTO> responseDTO = menuMapper.toResponseDto(allMenus);
        return TreeModule.buildTree(responseDTO);
    }

    @Override
    @Transactional
    public MenuResponseDTO addMenu(MenuDTO menuDTO) {
        // 1. Check duplicate menu code
        menuRepository.findByMenuCode(menuDTO.getMenuCode()).ifPresent(menu -> {
            throw new GlobalException(i18n.translate(CommonMessages.COMMON_DATA_EXISTED));
        });

        // 2. Map DTO → Entity
        Menu menu = menuMapper.toEntity(menuDTO);

        // 3. Build permission configs
        List<MenuPermissionConfig> permissionConfigs = buildMenuPermissionConfigs(menu, menuDTO.getPermissions());
        menu.setPermissionConfigs(permissionConfigs);

        // 4. Save
        Menu savedMenu = menuRepository.save(menu);

        return menuMapper.toResponseDto(savedMenu);
    }

    @Override
    @Transactional
    public MenuResponseDTO updateMenu(Long menuId, MenuDTO menuDTO) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND))
        );
        // Update field cơ bản
        menuMapper.updateFromDto(menuDTO, menu);
        // 3. Build permission configs
        List<MenuPermissionConfig> permissionConfigs = buildMenuPermissionConfigs(menu, menuDTO.getPermissions());

        menu.getPermissionConfigs().clear();
        menu.getPermissionConfigs().addAll(permissionConfigs);

        return menuMapper.toResponseDto(menuRepository.save(menu));
    }


    @Override
    public boolean deleteMenu(Long menuId) {
//        Menu menu = getMenuById(menuId);
//        menuRepository.delete(menu);

        return true;
    }

    private List<MenuPermissionConfig> buildMenuPermissionConfigs(Menu menu, List<String> permissionCds) {
        if (permissionCds == null || permissionCds.isEmpty()) {
            return List.of();
        }

        // Load permissions 1 lần
        Map<String, Permission> permissionMap = permissionRepository.findByPermissionCdIn(permissionCds)
                        .stream()
                        .collect(Collectors.toMap(
                                Permission::getPermissionCd,
                                Function.identity()
                        ));

        // Validate thiếu permission
        for (String cd : permissionCds) {
            if (!permissionMap.containsKey(cd)) {
                throw new GlobalException("Permission not found: " + cd);
            }
        }

        // Build configs
        return permissionCds.stream()
                .map(cd -> MenuPermissionConfig.builder()
                        .menu(menu)
                        .permission(permissionMap.get(cd))
                        .usedYn("Y")
                        .build())
                .toList();
    }
}
