package com.htn.mapper;

import com.htn.dto.TagDTO;
import com.htn.entity.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper extends BaseMapper<Tag, TagDTO>{
}
