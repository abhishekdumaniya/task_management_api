package com.abhishek.task_management_api.mapper.usermapper;

import com.abhishek.task_management_api.domain.entities.User;
import com.abhishek.task_management_api.dto.userdto.CreateUserRequest;
import com.abhishek.task_management_api.dto.userdto.GetAllUsersResponse;

public interface UserMapper {

    User fromDto(CreateUserRequest createUserRequest);
    CreateUserRequest toDto(User user);
    GetAllUsersResponse fromUser(User user);
}
