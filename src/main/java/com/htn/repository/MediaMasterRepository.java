package com.htn.repository;

import com.htn.entity.MediaMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MediaMasterRepository extends JpaRepository<MediaMaster, Long> {
    Optional<MediaMaster> findByFileName(String fileName);
}
