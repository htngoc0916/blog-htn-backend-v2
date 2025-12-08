package com.htn.repository;

import com.htn.entity.GroupCodeDtl;
import com.htn.entity.GroupCodeMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupCodeDtlRepository extends JpaRepository<GroupCodeDtl, Long>{
    Optional<GroupCodeDtl> findByCodeCdAndGroupCodeMst_GroupCd(String codeCd, String groupCd);

    // Lấy tất cả detail thuộc về 1 master group code, sắp xếp theo thứ tự
    @Query("SELECT d FROM GroupCodeDtl d WHERE d.groupCodeMst.groupCd = :groupCodeMstCode ORDER BY d.codeOrd ASC")
    List<GroupCodeDtl> findAllByMasterCode(String groupCodeMstCode);

    // lay groupMst theo codeCd
    @Query("SELECT m FROM GroupCodeMst m WHERE m.groupCd = :groupCd")
    Optional<GroupCodeMst> findGroupMstByGroupCd(String groupCd);
}
