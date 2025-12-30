package com.htn.service;

import com.htn.dto.GroupCodeDtlDTO;
import com.htn.dto.response.GroupCodeDtlResponseDTO;
import com.htn.dto.GroupCodeDtlSearchDTO;
import com.htn.entity.GroupCodeDtl;

import java.util.List;

public interface GroupCodeDtlService {
    //add
    GroupCodeDtl addGroupCodeDtl(GroupCodeDtlDTO groupCodeDtlDTO);
    GroupCodeDtl updateGroupCodeDtl(Long id, GroupCodeDtlDTO groupCodeDtlDTO);

    //get
    GroupCodeDtl getGroupCodeDtlById(Long id);
    List<GroupCodeDtlResponseDTO> getAllGroupCodeDtl(GroupCodeDtlSearchDTO searchDTO);

    //delete
    boolean deleteGroupCodeDtl(Long id);
}
