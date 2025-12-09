package com.htn.controller;

import com.htn.dto.GroupCodeDtlDTO;
import com.htn.dto.GroupCodeDtlSearchDTO;
import com.htn.service.GroupCodeDtlService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin/detail-codes")
public class GroupCodeDtlController extends BaseController {
    @Autowired
    private GroupCodeDtlService groupCodeDtlService;

    @GetMapping
    public ResponseEntity<?> getAllGroupCodeDtl(@ModelAttribute GroupCodeDtlSearchDTO searchDTO){
        return response(groupCodeDtlService.getAllGroupCodeDtl(searchDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGroupCodeDtlById(@PathVariable("id") Long id){
        return response(groupCodeDtlService.getGroupCodeDtlById(id));
    }

    @PostMapping
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<?> addGroupCodeDtl(@Valid @RequestBody GroupCodeDtlDTO dto) {
        return response(groupCodeDtlService.addGroupCodeDtl(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<?> updateGroupCodeDtl(@PathVariable("id") Long id,@Valid @RequestBody GroupCodeDtlDTO dto){
        return response(groupCodeDtlService.updateGroupCodeDtl(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<?> updateGroupCodeDtl(@PathVariable("id") Long id){
        return response(groupCodeDtlService.deleteGroupCodeDtl(id));
    }



}
