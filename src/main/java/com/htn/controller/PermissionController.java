package com.htn.controller;

import com.htn.dto.PermissionDTO;
import com.htn.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/permissions")
public class PermissionController extends BaseController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPermissionById(@PathVariable("id") Long id){
        return response(permissionService.getPermissionById(id));
    }

    @GetMapping()
    public ResponseEntity<?> getAllPermissions(){
        return response(permissionService.getAllPermissions());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<?> addPermission(@RequestBody PermissionDTO permissionDTO){
        return response(permissionService.addPermission(permissionDTO));
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePermission(@PathVariable("id") Long id,@RequestBody PermissionDTO permissionDTO){
        return response(permissionService.updatePermission(id, permissionDTO));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePermission(@PathVariable("id") Long id){
        return response(permissionService.deletePermission(id));
    }
}
