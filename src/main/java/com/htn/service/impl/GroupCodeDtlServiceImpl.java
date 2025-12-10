package com.htn.service.impl;

import com.htn.dto.GroupCodeDtlDTO;
import com.htn.dto.GroupCodeDtlResponseDTO;
import com.htn.dto.GroupCodeDtlSearchDTO;
import com.htn.entity.GroupCodeDtl;
import com.htn.entity.GroupCodeMst;
import com.htn.exception.GlobalException;
import com.htn.exception.NotFoundException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.GroupCodeDtlMapper;
import com.htn.mapper.mybatis.GroupCodeMbtMapper;
import com.htn.repository.GroupCodeDtlRepository;
import com.htn.repository.GroupCodeMstRepository;
import com.htn.service.GroupCodeDtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupCodeDtlServiceImpl implements GroupCodeDtlService {
    @Autowired
    private GroupCodeDtlRepository groupCodeDtlRepository;
    @Autowired
    private GroupCodeMstRepository groupCodeMstRepository;
    @Autowired
    private LocalizationService i18n;
    @Autowired
    private GroupCodeDtlMapper mapper;
    @Autowired
    private GroupCodeMbtMapper mbtMapper;


    @Override
    public GroupCodeDtl getGroupCodeDtlById(Long id) {
        return groupCodeDtlRepository.findById(id).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND_WITH, "id", id))
        );
    }

    @Override
    public List<GroupCodeDtlResponseDTO> getAllGroupCodeDtl(GroupCodeDtlSearchDTO searchDTO) {
        //get data
        List<GroupCodeDtlResponseDTO> list = mbtMapper.searchGroupDtls(searchDTO);
        if (list.isEmpty()) {return List.of();}

        return buildTree(list);
    }

    private List<GroupCodeDtlResponseDTO> buildTree(List<GroupCodeDtlResponseDTO> allCodes) {

        // Group by parentCd để tìm con nhanh hơn
        Map<String, List<GroupCodeDtlResponseDTO>> mapByParent =
                allCodes.stream()
                        .collect(Collectors.groupingBy(
                                item -> Optional.ofNullable(item.getParentCd()).orElse("")
                        ));

        // Tìm parent (những thằng có parentCd = null hoặc blank)
        List<GroupCodeDtlResponseDTO> roots = mapByParent.getOrDefault("", List.of());

        // build children đệ quy
        roots.forEach(root -> buildChildrenRecursive(root, mapByParent));

        return roots;
    }

    private void buildChildrenRecursive(GroupCodeDtlResponseDTO parent, Map<String, List<GroupCodeDtlResponseDTO>> mapByParent) {

        // Lấy danh sách các con theo parentCd
        List<GroupCodeDtlResponseDTO> children = mapByParent.getOrDefault(parent.getCodeCd(), List.of());
        parent.setChildren(children);

        // Đệ quy cho từng con
        children.forEach(child -> buildChildrenRecursive(child, mapByParent));
    }

    @Override
    @Transactional
    public GroupCodeDtl addGroupCodeDtl(GroupCodeDtlDTO dto) {

        // 1. Validate GroupCodeMst tồn tại
        GroupCodeMst mst = groupCodeMstRepository.findByGroupCd(dto.getGroupCd())
                .orElseThrow(() -> new NotFoundException(
                        i18n.translate(CommonMessages.COMMON_NOT_FOUND, dto.getGroupCd())
                ));

        // 2. Kiểm tra codeCd trùng
        groupCodeDtlRepository.findByCodeCdAndGroupCd(dto.getCodeCd(), dto.getGroupCd()).ifPresent(
                item -> {
                    throw new GlobalException(i18n.translate(CommonMessages.COMMON_DATA_EXISTED_WITH, "codeCd="+ dto.getCodeCd()));
                });

        // 3. Kiểm tra độ dài codeCd
        if (dto.getCodeCd().length() > mst.getCodeLength()) {
            throw new GlobalException(
                    i18n.translate(CommonMessages.COMMON_LENGTH_EXCEED_WITH, "codeCd", mst.getCodeLength())
            );
        }

        // 4. Convert DTO → Entity
        GroupCodeDtl entity = mapper.toEntity(dto);

        return groupCodeDtlRepository.save(entity);
    }

    @Override
    public GroupCodeDtl updateGroupCodeDtl(Long id, GroupCodeDtlDTO groupCodeDtlDTO) {
        GroupCodeDtl groupCodeDtl = getGroupCodeDtlById(id);
        // 2. Kiểm tra codeCd trùng
        if(!groupCodeDtl.getGroupCd().equals(groupCodeDtlDTO.getGroupCd()) &&
                !groupCodeDtl.getParentCd().equals(groupCodeDtlDTO.getParentCd()) &&
                !groupCodeDtl.getCodeCd().equals(groupCodeDtlDTO.getCodeCd())){
            throw new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND_WITH, "id="+id));
        }

        mapper.updateFromDto(groupCodeDtlDTO, groupCodeDtl);
        return groupCodeDtlRepository.save(groupCodeDtl);
    }

    @Override
    public boolean deleteGroupCodeDtl(Long id) {
        GroupCodeDtl groupCodeDtl = getGroupCodeDtlById(id);
        groupCodeDtlRepository.delete(groupCodeDtl);
        return true;
    }
}
