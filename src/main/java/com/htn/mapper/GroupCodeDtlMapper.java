package com.htn.mapper;

import com.htn.dto.GroupCodeDtlDTO;
import com.htn.entity.GroupCodeDtl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GroupCodeDtlMapper extends BaseMapper<GroupCodeDtl, GroupCodeDtlDTO>{
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "groupCd", ignore = true)
    @Mapping(target = "parentCd", ignore = true)
    @Mapping(target = "codeCd", ignore = true)
    void updateFromDto(GroupCodeDtlDTO dto, @MappingTarget GroupCodeDtl entity);

}
