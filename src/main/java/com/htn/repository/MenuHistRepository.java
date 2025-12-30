package com.htn.repository;

import com.htn.entity.MenuHist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuHistRepository extends JpaRepository<MenuHist, Long> {
}
