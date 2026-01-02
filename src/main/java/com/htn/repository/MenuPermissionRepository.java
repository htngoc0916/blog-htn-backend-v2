package com.htn.repository;

import com.htn.entity.MenuPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuPermissionRepository extends JpaRepository<MenuPermission, Long> {
}
