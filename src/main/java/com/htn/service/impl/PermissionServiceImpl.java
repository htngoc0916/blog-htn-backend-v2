package com.htn.service.impl;

import com.htn.dto.PermissionDTO;
import com.htn.entity.Permission;
import com.htn.exception.GlobalException;
import com.htn.exception.NotFoundException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.PermissionMapper;
import com.htn.repository.PermissionRepository;
import com.htn.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private LocalizationService i18n;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Permission getPermissionById(Long permissionId) {
        return permissionRepository.findById(permissionId).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND)
        ));
    }

    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission addPermission(PermissionDTO permission) {
        permissionRepository.findByPermissionCd(permission.getPermissionCd()).orElseThrow(
                () -> new GlobalException(i18n.translate(CommonMessages.COMMON_DATA_EXISTED))
        );
        Permission permissionEntity = permissionMapper.toEntity(permission);
        return permissionRepository.save(permissionEntity);
    }

    @Override
    public Permission updatePermission(Long id, PermissionDTO permission) {
        Permission permissionEntity = getPermissionById(id);
        permissionMapper.updateFromDto(permission, permissionEntity);
        return permissionRepository.save(permissionEntity);
    }

    @Override
    public boolean deletePermission(Long id) {
        Permission permission = getPermissionById(id);
        permissionRepository.delete(permission);
        return true;
    }
}
