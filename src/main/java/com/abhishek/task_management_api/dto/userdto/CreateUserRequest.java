package com.abhishek.task_management_api.dto.userdto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String name;
    private String email;
    private String password;
}
