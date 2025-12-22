package com.htn.service.impl;

import com.htn.dto.PageResponseDTO;
import com.htn.dto.TagDTO;
import com.htn.dto.TagSearchDTO;
import com.htn.entity.Tag;
import com.htn.exception.NotFoundException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.TagMapper;
import com.htn.repository.TagRepository;
import com.htn.service.TagService;
import com.htn.utils.PagingUtil;
import com.htn.utils.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private LocalizationService i18n;
    @Autowired
    private TagMapper tagMapper;

    @Override
    public Tag addTag(TagDTO tag) {

        // Step 1: Generate slug từ input
        String baseSlug = SlugUtil.generateSlug(tag.getTagName());

        // callback: kiểm tra slug exist
        String finalSlug = SlugUtil.toUniqueSlug(baseSlug,
                slug -> tagRepository.findByTagSlug(slug).isPresent()
        );

        //mapper
        Tag tagEntity = tagMapper.toEntity(tag);
        tagEntity.setTagSlug(finalSlug);

        return tagRepository.save(tagEntity);
    }
    @Override
    public Tag updateTag(Long id, TagDTO tag) {
        Tag tagEntity = getTagById(id);
        tagMapper.updateFromDto(tag, tagEntity);
        return tagRepository.save(tagEntity);
    }

    @Override
    public Tag getTagById(Long id) {
        return tagRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND_WITH,"Id=%"+ id))
        );
    }

    @Override
    public PageResponseDTO<Tag> searchTags(Pageable pageable, TagSearchDTO searchDTO) {
        PagingUtil.paginationValidate(pageable);

        //check search params
        Page<Tag> resultPage;
        if(StringUtils.hasText(searchDTO.getTagNm()) && StringUtils.hasText(searchDTO.getUsedYn())){
            resultPage = tagRepository.findByTagNameContainsAndUsedYn(searchDTO.getTagNm(),searchDTO.getUsedYn(), pageable);
        }else if(StringUtils.hasText(searchDTO.getTagNm())){
            resultPage = tagRepository.findByTagNameContains(searchDTO.getTagNm(), pageable);
        }else {
            resultPage = tagRepository.findAll(pageable);
        }

        return PageResponseDTO.of(resultPage);
    }

    @Override
    public boolean deleteTagById(Long id) {
        Tag tag = getTagById(id);
        tagRepository.delete(tag);
        return true;
    }
}
