package com.htn.repository;

import com.htn.entity.RoleMenuPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMenuPermissionRepository extends JpaRepository<RoleMenuPermission, Long> {
    List<RoleMenuPermission> findByRoleId(Long roleId);
    void deleteByRoleId(Long roleId);
}