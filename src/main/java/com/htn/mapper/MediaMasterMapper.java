package com.htn.mapper;

import com.htn.dto.MediaMasterDTO;
import com.htn.dto.response.UploadResponseDTO;
import com.htn.entity.MediaMaster;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MediaMasterMapper extends BaseMapper<MediaMaster, MediaMasterDTO> {
    MediaMaster uploadResponseToEntity(UploadResponseDTO dto);
}
