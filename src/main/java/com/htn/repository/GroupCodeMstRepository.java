package com.htn.repository;

import com.htn.entity.Category;
import com.htn.entity.GroupCodeMst;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupCodeMstRepository extends JpaRepository<GroupCodeMst, Long> {
    boolean existsByGroupCd(String groupCd);
    Optional<GroupCodeMst> findByGroupCd(String groupCd);

    Page<GroupCodeMst> findByGroupNmContainingAndUsedYn(String groupNm, String usedYn, Pageable pageable);
    Page<GroupCodeMst> findByGroupNmContaining(String groupNm, Pageable pageable);
    Page<GroupCodeMst> findByUsedYn(String usedYn, Pageable pageable);
}
