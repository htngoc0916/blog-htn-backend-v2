package com.htn.mapper;

import com.htn.dto.GroupCodeMstDTO;
import com.htn.entity.GroupCodeMst;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GroupCodeMstMapper extends BaseMapper<GroupCodeMst, GroupCodeMstDTO>{
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "groupCd", ignore = true)
    @Mapping(target = "codeLength", ignore = true)
    void updateFromDto(GroupCodeMstDTO dto, @MappingTarget GroupCodeMst entity);

}
