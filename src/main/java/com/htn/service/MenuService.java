package com.htn.service;

import com.htn.dto.MenuDTO;
import com.htn.dto.MenuResponseDTO;
import com.htn.entity.Menu;

import java.util.List;

public interface MenuService  {
    MenuResponseDTO getMenuById(Long menuId);
    List<MenuResponseDTO> getMenus();
    List<MenuResponseDTO> getMenuByCode(String menuCode);
    MenuResponseDTO addMenu(MenuDTO menuDTO);
    MenuResponseDTO updateMenu(Long menuId, MenuDTO menuDTO);
    boolean deleteMenu(Long menuId);
}
