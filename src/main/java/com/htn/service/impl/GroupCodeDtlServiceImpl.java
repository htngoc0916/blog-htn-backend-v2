package com.htn.service.impl;

import com.htn.dto.GroupCodeDtlDTO;
import com.htn.dto.GroupCodeDtlSearchDTO;
import com.htn.dto.PageResponseDTO;
import com.htn.entity.GroupCodeDtl;
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
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND, String.format("Id=%s", id)))
        );
    }

    @Override
    public PageResponseDTO<GroupCodeDtl> getAllGroupCodeDtl(Pageable pageable, GroupCodeDtlSearchDTO searchDTO) {
        return null;
    }

    @Override
    public GroupCodeDtl addGroupCodeDtl(GroupCodeDtlDTO groupCodeDtlDTO) {
        GroupCodeDtl groupCodeDtl = mapper.toEntity(groupCodeDtlDTO);

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
