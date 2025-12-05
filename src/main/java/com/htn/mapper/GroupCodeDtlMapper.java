package com.htn.mapper;

import com.htn.dto.GroupCodeDtlDTO;
import com.htn.entity.GroupCodeDtl;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupCodeDtlMapper extends BaseMapper<GroupCodeDtl, GroupCodeDtlDTO>{
}
