package com.htn.service;

import com.htn.dto.MenuDTO;
import com.htn.dto.MenuResponseDTO;
import com.htn.entity.Menu;

import java.util.List;

public interface MenuService  {
    Menu getMenuById(Long menuId);
    List<MenuResponseDTO> getMenus();
    List<MenuResponseDTO> getMenuByCode(String menuCode);
    Menu addMenu(MenuDTO menuDTO);
    Menu updateMenu(Long menuId, MenuDTO menuDTO);
    boolean deleteMenu(Long menuId);
}
