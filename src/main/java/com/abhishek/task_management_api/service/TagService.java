package com.abhishek.task_management_api.service;

import com.abhishek.task_management_api.dto.tagdto.CreateTagRequest;
import com.abhishek.task_management_api.dto.tagdto.CreateTagResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TagService {
    ResponseEntity<CreateTagResponse> createTag(CreateTagRequest request);

    ResponseEntity<List<CreateTagResponse>> getAllTags();
}
