package com.htn.service.impl;

import com.htn.dto.GroupCodeDtlDTO;
import com.htn.dto.GroupCodeDtlSearchDTO;
import com.htn.dto.PageResponseDTO;
import com.htn.entity.GroupCodeDtl;
import com.htn.entity.GroupCodeMst;
import com.htn.exception.GlobalException;
import com.htn.exception.NotFoundException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.GroupCodeDtlMapper;
import com.htn.repository.GroupCodeDtlRepository;
import com.htn.service.GroupCodeDtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GroupCodeDtlServiceImpl implements GroupCodeDtlService {
    @Autowired
    private GroupCodeDtlRepository groupCodeDtlRepository;
    @Autowired
    private LocalizationService i18n;
    @Autowired
    private GroupCodeDtlMapper mapper;



    @Override
    public GroupCodeDtl getGroupCodeDtlById(Long id) {
        return groupCodeDtlRepository.findById(id).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND_WITH, String.format("Id=%s", id)))
        );
    }

    @Override
    public PageResponseDTO<GroupCodeDtl> getAllGroupCodeDtl(Pageable pageable, GroupCodeDtlSearchDTO searchDTO) {
        return null;
    }

    @Override
    public GroupCodeDtl addGroupCodeDtl(GroupCodeDtlDTO dto) {
        //Neu groupCd khong ton tai
        GroupCodeMst mst = groupCodeDtlRepository.findGroupMstByGroupCd(dto.getGroupCd()).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND))
        );

        //Neu codeCd da ton tai
        groupCodeDtlRepository.findByCodeCdAndGroupCodeMst_GroupCd(dto.getCodeCd(), dto.getGroupCd()).ifPresent(
                item -> {
                    throw new GlobalException(i18n.translate(CommonMessages.COMMON_DATA_EXISTED));
                }
        );
        // check length
        if(dto.getCodeCd().length() != mst.getCodeLength()){
            throw new RuntimeException("Code length is incorrect");
        }

        GroupCodeDtl groupCodeDtl = mapper.toEntity(dto);
        return groupCodeDtlRepository.save(groupCodeDtl);
    }

    @Override
    public GroupCodeDtl updateGroupCodeDtl(Long id, GroupCodeDtlDTO groupCodeDtlDTO) {
        return null;
    }

    @Override
    public boolean deleteGroupCodeDtl(Long id) {
        return false;
    }
}
