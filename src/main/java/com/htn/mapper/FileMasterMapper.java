package com.htn.mapper;

import com.htn.dto.UploadResponseDTO;
import com.htn.entity.FileMaster;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FileMasterMapper {
    FileMaster toEntity(UploadResponseDTO dto);
    UploadResponseDTO toResponseDto(FileMaster fileMaster);
    void updateFromDto(UploadResponseDTO dto, @MappingTarget FileMaster fileMaster);
}
