package com.htn.service;

import com.htn.dto.RoleDTO;
import com.htn.dto.search.RoleSearchDTO;
import com.htn.entity.Role;

import java.util.List;

public interface RoleService {
    //save
    Role addRole(RoleDTO role);
    Role updateRole(Long roleId, RoleDTO role);

    //get
    Role getRoleById(Long id);
    List<Role> searchRole(RoleSearchDTO searchDTO);
}
