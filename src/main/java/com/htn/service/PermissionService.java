package com.htn.service;

import com.htn.dto.PermissionDTO;
import com.htn.entity.Permission;

import java.util.List;

public interface PermissionService {
    //get
    Permission getPermissionById(Long permissionId);
    List<Permission> getAllPermissions();

    //save
    Permission addPermission(PermissionDTO permission);
    Permission updatePermission(Long id, PermissionDTO permission);

    //delete
    boolean deletePermission(Long id);
}
