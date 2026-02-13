package com.abhishek.task_management_api.mapper.usermapper.impl;

import com.abhishek.task_management_api.domain.entities.User;
import com.abhishek.task_management_api.dto.userdto.CreateUserRequest;
import com.abhishek.task_management_api.dto.userdto.GetAllUsersResponse;
import com.abhishek.task_management_api.mapper.usermapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User fromDto(CreateUserRequest createUserRequest) {
        return new User(
                null,
                createUserRequest.getName(),
                createUserRequest.getEmail(),
                createUserRequest.getPassword(),
                null,
                null,
                null,
                null,
                null
        );
    }

    @Override
    public CreateUserRequest toDto(User user) {
        return new CreateUserRequest();
    }

    @Override
    public GetAllUsersResponse fromUser(User user) {
        return new GetAllUsersResponse(
                user.getUserId(),
                user.getUserName(),
                user.getUserEmail()
        );
    }
}
