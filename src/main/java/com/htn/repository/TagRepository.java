package com.htn.repository;

import com.htn.entity.Category;
import com.htn.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByTagSlug(String tagSlug);

    Page<Tag> findByTagNameContainsAndUsedYn(String categoryName, String usedYn, Pageable pageable);
    Page<Tag> findByTagNameContains(String categoryName, Pageable pageable);
    Page<Tag> findByUsedYn(String usedYn, Pageable pageable);
}
