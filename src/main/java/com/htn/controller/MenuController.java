package com.htn.controller;

import com.htn.dto.MenuDTO;
import com.htn.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/menus")
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;

    @Operation(summary = "Get menu by id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getMenuById(@PathVariable("id") Long menuId){
        return response(menuService.getMenuById(menuId));
    }

    @Operation(summary = "Get menus by menu code")
    @GetMapping("/codes/{code}")
    public ResponseEntity<?> getMenuByCode(@PathVariable("code") String menuCode){
        return response(menuService.getMenuByCode(menuCode));
    }

    @Operation(summary = "Get all menus")
    @GetMapping
    public ResponseEntity<?> getMenus(){
        return response(menuService.getMenus());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<?> addMenu(@Valid @RequestBody MenuDTO menuDTO){
        return response(menuService.addMenu(menuDTO));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMenu(@Valid @PathVariable("id") Long menuId, @RequestBody MenuDTO menuDTO){
        return response(menuService.updateMenu(menuId, menuDTO));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable("id") Long menuId) {
        return response(menuService.deleteMenu(menuId));
    }
}
