package com.htn.service.impl;

import com.htn.dto.GroupCodeMstDTO;
import com.htn.dto.GroupCodeMstSearchDTO;
import com.htn.dto.PageResponseDTO;
import com.htn.entity.GroupCodeMst;
import com.htn.exception.GlobalException;
import com.htn.exception.NotFoundException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.GroupCodeMstMapper;
import com.htn.repository.GroupCodeMstRepository;
import com.htn.service.GroupCodeMstService;
import com.htn.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class GroupCodeMstServiceImpl implements GroupCodeMstService {
    @Autowired
    private GroupCodeMstRepository groupCodeMstRepository;
    @Autowired
    private LocalizationService i18n;
    @Autowired
    private GroupCodeMstMapper mapper;

    @Override
    public boolean existsGroupCd(String groupCd) {
        return groupCodeMstRepository.existsByGroupCd(groupCd);
    }

    @Override
    public GroupCodeMst getGroupCodeMstById(Long id) {
        return groupCodeMstRepository.findById(id).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND_WITH, String.format("Id=%s", id)))
        );
    }

    @Override
    public GroupCodeMst getGroupCodeMstByGroupCd(String groupCd) {
        return groupCodeMstRepository.findByGroupCd(groupCd).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND_WITH, String.format("GroupCd=%s", groupCd)))
        );
    }

    @Override
    public PageResponseDTO<GroupCodeMst> getAllGroupCodeMst(Pageable pageable, GroupCodeMstSearchDTO searchDTO) {
        //validation
        Utils.paginationValidate(pageable);

        //check search params
        Page<GroupCodeMst> resultPage;
        if (StringUtils.hasText(searchDTO.getGroupNm()) && StringUtils.hasText(searchDTO.getUsedYn())) {
            resultPage = groupCodeMstRepository.findByGroupNmContainingAndUsedYn(searchDTO.getGroupNm(),searchDTO.getUsedYn(), pageable);
        } else if (StringUtils.hasText(searchDTO.getGroupNm())) {
            resultPage = groupCodeMstRepository.findByGroupNmContaining(searchDTO.getGroupNm(), pageable);
        } else if (StringUtils.hasText(searchDTO.getUsedYn())) {
            resultPage = groupCodeMstRepository.findByUsedYn(searchDTO.getUsedYn(), pageable);
        } else {
            resultPage = groupCodeMstRepository.findAll(pageable);
        }

        return PageResponseDTO.of(resultPage);
    }

    //add
    @Override
    public GroupCodeMst addGroupCodeMst(GroupCodeMstDTO dto) {
        if(existsGroupCd(dto.getGroupCd())){
            throw new GlobalException(i18n.translate(CommonMessages.COMMON_DATA_EXISTED, String.format("CategoryCd = %s", dto.getGroupCd())));
        }

        GroupCodeMst groupCodeMst = mapper.toEntity(dto);
        return groupCodeMstRepository.save(groupCodeMst);
    }

    //update
    @Override
    public GroupCodeMst updateGroupCodeMst(Long id, GroupCodeMstDTO dto) {
        GroupCodeMst groupCodeMst = getGroupCodeMstById(id);
        mapper.updateFromDto(dto, groupCodeMst);
        return groupCodeMstRepository.save(groupCodeMst);
    }

    //delete
    @Override
    public boolean deleteGroupCodeMst(Long id) {
        GroupCodeMst groupCodeMst = getGroupCodeMstById(id);
        groupCodeMstRepository.delete(groupCodeMst);
        return true;
    }
}
