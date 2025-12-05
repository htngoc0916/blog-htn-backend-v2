package com.htn.repository;

import com.htn.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findByCategoryNmContainingAndUsedYn(String categoryName, String usedYn, Pageable pageable);
    Page<Category> findByCategoryNmContaining(String categoryName, Pageable pageable);
    Page<Category> findByUsedYn(String usedYn, Pageable pageable);
}
