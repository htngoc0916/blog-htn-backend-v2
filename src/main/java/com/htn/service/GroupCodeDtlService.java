package com.htn.service;

import com.htn.dto.GroupCodeDtlDTO;
import com.htn.dto.GroupCodeDtlSearchDTO;
import com.htn.dto.PageResponseDTO;
import com.htn.entity.GroupCodeDtl;
import org.springframework.data.domain.Pageable;

public interface GroupCodeDtlService {
    //add
    GroupCodeDtl addGroupCodeDtl(GroupCodeDtlDTO groupCodeDtlDTO);
    GroupCodeDtl updateGroupCodeDtl(Long id, GroupCodeDtlDTO groupCodeDtlDTO);

    //get
    GroupCodeDtl getGroupCodeDtlById(Long id);
    PageResponseDTO<GroupCodeDtl> getAllGroupCodeDtl(Pageable pageable, GroupCodeDtlSearchDTO searchDTO);

    //delete
    boolean deleteGroupCodeDtl(Long id);
}
