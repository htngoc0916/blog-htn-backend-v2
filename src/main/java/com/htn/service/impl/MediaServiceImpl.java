package com.htn.service.impl;

import com.htn.dto.MediaMasterDTO;
import com.htn.dto.response.MediaResponseDTO;
import com.htn.dto.search.MediaSearchDTO;
import com.htn.dto.response.PageResponseDTO;
import com.htn.entity.MediaMaster;
import com.htn.exception.NotFoundException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.mybatis.MediaMbtMapper;
import com.htn.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MediaServiceImpl implements MediaService {
    @Autowired
    MediaMbtMapper mediaMbtMapper;
    @Autowired
    LocalizationService i18n;

    @Override
    public MediaResponseDTO getMedia(Long mediaId) {
        return mediaMbtMapper.getMedia(mediaId).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND_WITH, "MediaId="+mediaId))
        );
    }

    @Override
    public PageResponseDTO<MediaMaster> searchMedia(MediaSearchDTO searchDTO, Pageable pageable) {
        return null;
    }

    @Override
    public MediaResponseDTO addMedia(MediaMasterDTO mediaMaster) {
        return null;
    }

    @Override
    public MediaResponseDTO updateMedia(Long id, MediaMasterDTO mediaMaster) {
        return null;
    }

    @Override
    public boolean deleteMedia(Long id) {
        return false;
    }
}
