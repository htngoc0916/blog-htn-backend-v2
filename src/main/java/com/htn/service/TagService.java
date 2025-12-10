package com.htn.service;

import com.htn.dto.PageResponseDTO;
import com.htn.dto.TagDTO;
import com.htn.dto.TagSearchDTO;
import com.htn.entity.Tag;
import org.springframework.data.domain.Pageable;

public interface TagService {
    //save
    Tag addTag(TagDTO tag);
    Tag updateTag(Long id, TagDTO tag);

    //get
    Tag getTagById(Long id);
    PageResponseDTO<Tag> searchTags(Pageable pageable, TagSearchDTO searchDTO);

    //delete
    boolean deleteTagById(Long id);
}
