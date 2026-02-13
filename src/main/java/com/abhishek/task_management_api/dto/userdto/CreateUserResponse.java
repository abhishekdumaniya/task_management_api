package com.abhishek.task_management_api.dto.userdto;

import lombok.Data;

@Data
public class CreateUserResponse {
    private String message;
    private Long userId;
}
