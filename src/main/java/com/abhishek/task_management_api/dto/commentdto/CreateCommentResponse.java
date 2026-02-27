package com.abhishek.task_management_api.dto.commentdto;

import com.abhishek.task_management_api.domain.entities.User;
import com.abhishek.task_management_api.dto.userdto.GetAllUsersResponse;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateCommentResponse {
    private Long id;
    private String text;
    private GetAllUsersResponse user;
    private LocalDateTime createdAt;
}
