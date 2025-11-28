package com.htn.repository;

import com.htn.entity.GroupCodeMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupCodeMstRepository extends JpaRepository<GroupCodeMst, Long> {
}
