package com.htn.repository;

import com.htn.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByMenuCodeAndUsedYnOrderByMenuOrdAsc(String menuCode, String usedYn);
}
