package com.htn.repository;

import com.htn.entity.FileMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileMasterRepository extends JpaRepository<FileMaster, Long> {
    Optional<FileMaster> findByFileName(String fileName);
}
