package com.abhishek.task_management_api.mapper.commentmapper.impl;

import com.abhishek.task_management_api.domain.entities.Comment;
import com.abhishek.task_management_api.domain.entities.User;
import com.abhishek.task_management_api.dto.commentdto.CreateCommentRequest;
import com.abhishek.task_management_api.dto.commentdto.UserResponse;
import com.abhishek.task_management_api.mapper.commentmapper.CommentMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CommentMapperImpl implements CommentMapper {
    @Override
    public Comment fromComment(CreateCommentRequest createCommentRequest) {
        return new Comment(
                null,
                createCommentRequest.getText(),
                LocalDateTime.now(),
                null,
                null
        );
    }

    @Override
    public UserResponse fromUser(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getUserName()
        );
    }
}
