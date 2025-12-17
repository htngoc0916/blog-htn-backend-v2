package com.htn.mapper.mybatis;

import com.htn.dto.MediaResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MediaMbtMapper {
    Optional<MediaResponseDTO> getMedia(Long mediaId);
}
