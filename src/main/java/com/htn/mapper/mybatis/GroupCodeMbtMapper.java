package com.htn.mapper.mybatis;

import com.htn.dto.response.GroupCodeDtlResponseDTO;
import com.htn.dto.GroupCodeDtlSearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupCodeMbtMapper {
    List<GroupCodeDtlResponseDTO> searchGroupDtls(GroupCodeDtlSearchDTO searchDTO);
}
