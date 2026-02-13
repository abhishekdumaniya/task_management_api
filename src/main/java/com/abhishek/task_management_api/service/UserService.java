package com.abhishek.task_management_api.service;

import com.abhishek.task_management_api.dto.userdto.CreateUserRequest;
import com.abhishek.task_management_api.dto.userdto.CreateUserResponse;
import com.abhishek.task_management_api.dto.userdto.GetAllUsersResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {

    ResponseEntity<CreateUserResponse> createUser(CreateUserRequest createUserRequest);

    ResponseEntity<List<GetAllUsersResponse>> getAllUsers();

    ResponseEntity<String> deleteUser(Long id);
}
