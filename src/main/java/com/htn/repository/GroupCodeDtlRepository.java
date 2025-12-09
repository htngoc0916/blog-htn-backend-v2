package com.htn.repository;

import com.htn.entity.GroupCodeDtl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupCodeDtlRepository extends JpaRepository<GroupCodeDtl, Long>{
    Optional<GroupCodeDtl> findByCodeCdAndGroupCd(String codeCd, String groupCd);
}
