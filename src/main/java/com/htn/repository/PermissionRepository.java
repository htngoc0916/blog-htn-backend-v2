package com.htn.repository;

import com.htn.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findByPermissionCd(String permissionCd);
    List<Permission> findByPermissionCdIn(List<String> permissions);
}
