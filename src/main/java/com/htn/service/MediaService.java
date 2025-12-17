package com.htn.service;

import com.htn.dto.MediaMasterDTO;
import com.htn.dto.MediaResponseDTO;
import com.htn.dto.MediaSearchDTO;
import com.htn.dto.PageResponseDTO;
import com.htn.entity.MediaMaster;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MediaService {
    MediaResponseDTO getMedia(Long mediaId);
    PageResponseDTO<MediaMaster> searchMedia(MediaSearchDTO searchDTO, Pageable pageable);

    //save
    MediaResponseDTO addMedia(MediaMasterDTO mediaMaster);
    MediaResponseDTO updateMedia(Long id, MediaMasterDTO mediaMaster);

    //delete
    boolean deleteMedia(Long id);
}
