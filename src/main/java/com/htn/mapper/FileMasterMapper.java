package com.htn.mapper;

import com.htn.dto.UploadResponseDTO;
import com.htn.entity.FileMaster;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMasterMapper {
    FileMaster toEntity(UploadResponseDTO dto);
}
