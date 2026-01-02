package com.htn.service.impl;

import com.htn.dto.RoleDTO;
import com.htn.dto.RoleMenuPermissionDTO;
import com.htn.dto.response.RoleMenuResponseDTO;
import com.htn.dto.search.RoleSearchDTO;
import com.htn.entity.MenuPermission;
import com.htn.entity.Role;
import com.htn.entity.RoleMenuPermission;
import com.htn.exception.GlobalException;
import com.htn.exception.NotFoundException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.RoleMapper;
import com.htn.repository.MenuPermissionRepository;
import com.htn.repository.RoleMenuPermissionRepository;
import com.htn.repository.RoleRepository;
import com.htn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMenuPermissionRepository rmpRepository;
    @Autowired
    private MenuPermissionRepository mpRepository;

    @Autowired
    private LocalizationService i18n;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND))
        );
    }

    @Override
    public List<Role> searchRoles(RoleSearchDTO searchDTO) {
        List<Role> resutl;
        if(StringUtils.hasText(searchDTO.getKeyword())){
            resutl = roleRepository.findByRoleNameContainingIgnoreCaseOrRoleCodeContainingIgnoreCase(searchDTO.getKeyword(), searchDTO.getKeyword());
        }else {
            resutl = roleRepository.findAll();
        }
        return resutl;
    }

    @Override
    public Role addRole(RoleDTO roleDTO) {
        if(roleRepository.existsByRoleCode(roleDTO.getRoleCode())){
            throw new GlobalException(i18n.translate(CommonMessages.COMMON_DATA_EXISTED));
        }
        return roleRepository.save(roleMapper.toEntity(roleDTO));
    }

    @Override
    @Transactional
    public Role updateRole(Long roleId, RoleDTO roleDTO) {
        Role role = getRoleById(roleId);
        roleMapper.updateFromDto(roleDTO, role);

        rmpRepository.deleteByRoleId(roleId);
        savePermissions(role, roleDTO.getMenuPermissions());
        return roleRepository.save(role);
    }

    private void savePermissions(Role role, List<RoleMenuPermissionDTO> menuPermissions) {
        if (menuPermissions == null) return;

        List<RoleMenuPermission> entities = new ArrayList<>();
        for (RoleMenuPermissionDTO dto : menuPermissions) {
            //menu permission
            MenuPermission mp = mpRepository.findById(dto.getId()).orElseThrow(
                    () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND))
            );

            RoleMenuPermission rmp = new RoleMenuPermission();
            rmp.setRole(role);
            rmp.setMenuPermission(mp);
            entities.add(rmp);
        }
        rmpRepository.saveAll(entities);
    }

    @Override
    public List<RoleMenuResponseDTO> getMenusByRole(Long roleId){
        return null;
    }
}
