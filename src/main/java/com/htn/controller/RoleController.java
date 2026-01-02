package com.htn.controller;

import com.htn.dto.RoleDTO;
import com.htn.dto.search.RoleSearchDTO;
import com.htn.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/roles")
public class RoleController extends BaseController{
    @Autowired
    private RoleService roleService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getRole(@PathVariable("id") Long id){
        return response(roleService.getRoleById(id));
    }

    @GetMapping
    public ResponseEntity<?> searchRoles(@ModelAttribute RoleSearchDTO searchDTO){
        return response(roleService.searchRoles(searchDTO));
    }

    @GetMapping("/{id}/menus")
    public ResponseEntity<?> getMenusByRoleId(@PathVariable("id") Long roleId){
        return response(roleService.getMenusByRole(roleId));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> addRole(@Valid @RequestBody RoleDTO roleDTO){
        return response(roleService.addRole(roleDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> updateRole(@PathVariable("id") Long id, @Valid @RequestBody RoleDTO roleDTO){
        return response(roleService.updateRole(id, roleDTO));
    }

}
