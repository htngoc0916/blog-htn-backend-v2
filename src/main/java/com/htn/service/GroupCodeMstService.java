package com.htn.service;

import com.htn.dto.GroupCodeMstDTO;
import com.htn.dto.GroupCodeMstSearchDTO;
import com.htn.dto.response.PageResponseDTO;
import com.htn.entity.GroupCodeMst;
import org.springframework.data.domain.Pageable;

public interface GroupCodeMstService {
    //save
    boolean existsGroupCd(String groupCd);
    GroupCodeMst addGroupCodeMst(GroupCodeMstDTO groupCodeMstDTO);
    GroupCodeMst updateGroupCodeMst(Long id, GroupCodeMstDTO groupCodeMstDTO);

    //get
    GroupCodeMst getGroupCodeMstById(Long id);
    GroupCodeMst getGroupCodeMstByGroupCd(String groupCd);
    PageResponseDTO<GroupCodeMst> getAllGroupCodeMst(Pageable pageable, GroupCodeMstSearchDTO searchDTO);

    //delete
    boolean deleteGroupCodeMst(Long id);
}
