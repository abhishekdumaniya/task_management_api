package com.abhishek.task_management_api.controller;

import com.abhishek.task_management_api.dto.tagdto.CreateTagRequest;
import com.abhishek.task_management_api.dto.tagdto.CreateTagResponse;
import com.abhishek.task_management_api.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService service;

    @PostMapping
    public ResponseEntity<CreateTagResponse> createTag(@RequestBody CreateTagRequest request){
        return service.createTag(request);
    }

    @GetMapping
    public ResponseEntity<List<CreateTagResponse>> getAllTags(){
        return service.getAllTags();
    }

}
