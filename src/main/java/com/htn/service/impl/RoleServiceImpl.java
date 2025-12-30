package com.htn.service.impl;

import com.htn.dto.RoleDTO;
import com.htn.dto.search.RoleSearchDTO;
import com.htn.entity.Role;
import com.htn.exception.GlobalException;
import com.htn.exception.NotFoundException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.RoleMapper;
import com.htn.repository.RoleRepository;
import com.htn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
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
    public List<Role> searchRole(RoleSearchDTO searchDTO) {
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
    public Role updateRole(Long roleId, RoleDTO roleDTO) {
        Role role = getRoleById(roleId);
        roleMapper.updateFromDto(roleDTO, role);
        return null;
    }
}
