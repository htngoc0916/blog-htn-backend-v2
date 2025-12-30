package com.htn.service;

import com.htn.dto.MenuDTO;
import com.htn.dto.response.MenuResponseDTO;

import java.util.List;

public interface MenuService  {
    //get
    MenuResponseDTO getMenuById(Long menuId);
    MenuResponseDTO getMenuByCode(String menuCode);
    List<MenuResponseDTO> getMenus();

    //save
    MenuResponseDTO addMenu(MenuDTO menuDTO);
    MenuResponseDTO updateMenu(Long menuId, MenuDTO menuDTO);
    boolean deleteMenu(Long menuId);
}
