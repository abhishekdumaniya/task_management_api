package com.abhishek.task_management_api.mapper.commentmapper;

import com.abhishek.task_management_api.domain.entities.Comment;
import com.abhishek.task_management_api.domain.entities.User;
import com.abhishek.task_management_api.dto.commentdto.CreateCommentRequest;
import com.abhishek.task_management_api.dto.commentdto.CreateCommentResponse;
import com.abhishek.task_management_api.dto.commentdto.UserResponse;

public interface CommentMapper {

    Comment fromComment(CreateCommentRequest createCommentRequest);
    UserResponse fromUser(User user);
}
