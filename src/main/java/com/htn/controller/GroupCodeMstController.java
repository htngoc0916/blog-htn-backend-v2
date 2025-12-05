package com.htn.controller;

import com.htn.dto.GroupCodeMstDTO;
import com.htn.dto.GroupCodeMstSearchDTO;
import com.htn.service.GroupCodeMstService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin/group-codes")
public class GroupCodeMstController extends BaseController {
    @Autowired
    private GroupCodeMstService groupCodeMstService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getGroupCodeMstById(@PathVariable("id") Long id){
        return response(groupCodeMstService.getGroupCodeMstById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllGroupCodes(@SortDefault(sort = "id", direction = Sort.Direction.DESC)
                                                  @PageableDefault Pageable pageable,
                                              @Valid @ModelAttribute GroupCodeMstSearchDTO groupCodeMstSearchDTO){
        return response(groupCodeMstService.getAllGroupCodeMst(pageable, groupCodeMstSearchDTO));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addGroupCodeMst(@RequestBody GroupCodeMstDTO dto){
        return response(groupCodeMstService.addGroupCodeMst(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateGroupCodeMst(@PathVariable("id") Long id, @RequestBody GroupCodeMstDTO dto){
        return response(groupCodeMstService.updateGroupCodeMst(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteGroupCodeMst(@PathVariable("id") Long id){
        return response(groupCodeMstService.deleteGroupCodeMst(id));
    }
}
