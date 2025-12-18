package com.htn.controller;

import com.htn.dto.CategoryDTO;
import com.htn.dto.CategorySearchDTO;
import com.htn.service.CategoryService;
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
@RequestMapping("/api/v1/admin/categories")
public class CategoryController extends BaseController {
    @Autowired
    private CategoryService categoryServices;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable("id") Long id) {
        return response(categoryServices.getCategory(id));
    }

    @GetMapping()
    public ResponseEntity<?> searchAllCategories(@SortDefault(sort = "id", direction = Sort.Direction.DESC)
                                              @PageableDefault Pageable pageable,
                                              @Valid @ModelAttribute CategorySearchDTO categorySearchDTO) {
        return response(categoryServices.searchAllCategories(pageable, categorySearchDTO));
    }

    @PostMapping
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        return response(categoryServices.addCategory(categoryDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        return response(categoryServices.updateCategory(id, categoryDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        return response(categoryServices.deleteCategory(id));
    }
}
