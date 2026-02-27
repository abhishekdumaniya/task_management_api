package com.abhishek.task_management_api.mapper.tagmapper.impl;

import com.abhishek.task_management_api.domain.entities.Tag;
import com.abhishek.task_management_api.dto.tagdto.CreateTagRequest;
import com.abhishek.task_management_api.dto.tagdto.CreateTagResponse;
import com.abhishek.task_management_api.mapper.tagmapper.TagMapper;
import org.springframework.stereotype.Component;

@Component
public class TagMapperImpl implements TagMapper {
    @Override
    public Tag fromCreateTagRequest(CreateTagRequest request) {
        return new Tag(
                null,
                request.getName(),
                null
        );
    }

    @Override
    public CreateTagResponse fromTag(Tag tag) {
        return new CreateTagResponse(
                tag.getTagName(),
                tag.getTagId()
        );
    }
}
