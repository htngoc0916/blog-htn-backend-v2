package com.htn.controller;


import com.htn.dto.TagDTO;
import com.htn.dto.search.TagSearchDTO;
import com.htn.service.TagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/tags")
public class TagController extends BaseController {
    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<?> searchTags(@SortDefault(sort = "id", direction = Sort.Direction.DESC)
                                            @PageableDefault Pageable pageable,
                                        @Valid @ModelAttribute TagSearchDTO searchDTO){
        return response(tagService.searchTags(pageable, searchDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTagById(@PathVariable("id") Long id){
        return response(tagService.getTagById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> addTag(@Valid @RequestBody TagDTO tagDTO){
        return response(tagService.addTag(tagDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> updateTag(@PathVariable("id") Long id, @Valid @RequestBody TagDTO tagDTO){
        return response(tagService.updateTag(id, tagDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteTag(@PathVariable("id") Long id){
        return response(tagService.deleteTagById(id));
    }
}
