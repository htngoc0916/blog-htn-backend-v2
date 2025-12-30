package com.htn.repository;

import com.htn.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String rolName);
    List<Role> findByRoleNameContainingIgnoreCaseOrRoleCodeContainingIgnoreCase(String roleName, String roleCode);

    boolean existsByRoleCode(String roleCode);
}
