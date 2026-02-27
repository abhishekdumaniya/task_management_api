package com.abhishek.task_management_api.mapper.tagmapper;

import com.abhishek.task_management_api.domain.entities.Tag;
import com.abhishek.task_management_api.dto.tagdto.CreateTagRequest;
import com.abhishek.task_management_api.dto.tagdto.CreateTagResponse;

public interface TagMapper {
    Tag fromCreateTagRequest(CreateTagRequest request);
    CreateTagResponse fromTag(Tag tag);
}
