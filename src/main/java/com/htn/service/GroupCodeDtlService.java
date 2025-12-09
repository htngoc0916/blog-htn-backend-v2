package com.htn.service;

import com.htn.dto.GroupCodeDtlDTO;
import com.htn.dto.GroupCodeDtlResponseDTO;
import com.htn.dto.GroupCodeDtlSearchDTO;
import com.htn.dto.PageResponseDTO;
import com.htn.entity.GroupCodeDtl;
import org.springframework.data.domain.Pageable;

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
