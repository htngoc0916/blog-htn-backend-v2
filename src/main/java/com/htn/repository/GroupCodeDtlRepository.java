package com.htn.repository;

import com.htn.entity.GroupCodeDtl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupCodeDtlRepository extends JpaRepository<GroupCodeDtl, Long>{
    // Lấy tất cả detail thuộc về 1 master group code, sắp xếp theo thứ tự
    @Query("SELECT d FROM GroupCodeDtl d WHERE d.groupCodeMst.groupCd = :groupCodeMstCode ORDER BY d.codeOrd ASC")
    List<GroupCodeDtl> findAllByMasterCode(String groupCodeMstCode);
}
