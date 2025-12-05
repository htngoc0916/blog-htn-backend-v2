package com.htn.mapper;

import com.htn.dto.GroupCodeMstDTO;
import com.htn.entity.GroupCodeMst;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupCodeMstMapper extends BaseMapper<GroupCodeMst, GroupCodeMstDTO>{
}
