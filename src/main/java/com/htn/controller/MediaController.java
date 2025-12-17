package com.htn.controller;

import com.htn.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/media")
public class MediaController extends BaseController {
    @Autowired
    private MediaService mediaService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMedia(@PathVariable("id") Long id){
        return response(mediaService.getMedia(id));
    }

    @GetMapping("groups")
    public ResponseEntity<?> getMediaByGroup(){
        return null;
    }
}
