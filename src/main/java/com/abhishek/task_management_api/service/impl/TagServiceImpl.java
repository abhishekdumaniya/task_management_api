package com.abhishek.task_management_api.service.impl;

import com.abhishek.task_management_api.domain.entities.Tag;
import com.abhishek.task_management_api.dto.tagdto.CreateTagRequest;
import com.abhishek.task_management_api.dto.tagdto.CreateTagResponse;
import com.abhishek.task_management_api.mapper.tagmapper.TagMapper;
import com.abhishek.task_management_api.repository.TagRepository;
import com.abhishek.task_management_api.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    @Override
    public ResponseEntity<CreateTagResponse> createTag(CreateTagRequest request) {
        Tag tag = tagMapper.fromCreateTagRequest(request);
        tagRepository.save(tag);
        CreateTagResponse response = new CreateTagResponse(request.getName(), tag.getTagId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CreateTagResponse>> getAllTags() {
        List<Tag> list = tagRepository.findAll();
        List<CreateTagResponse> responses = new ArrayList<>();

        for (Tag tag : list){
            CreateTagResponse res = tagMapper.fromTag(tag);
            responses.add(res);
        }

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
