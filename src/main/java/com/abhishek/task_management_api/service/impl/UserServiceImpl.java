package com.abhishek.task_management_api.service.impl;

import com.abhishek.task_management_api.domain.entities.Task;
import com.abhishek.task_management_api.domain.entities.User;
import com.abhishek.task_management_api.domain.enums.Status;
import com.abhishek.task_management_api.dto.userdto.CreateUserRequest;
import com.abhishek.task_management_api.dto.userdto.CreateUserResponse;
import com.abhishek.task_management_api.dto.userdto.GetAllUsersResponse;
import com.abhishek.task_management_api.mapper.usermapper.UserMapper;
import com.abhishek.task_management_api.repository.TaskRepository;
import com.abhishek.task_management_api.repository.UserRepository;
import com.abhishek.task_management_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final TaskRepository taskRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public ResponseEntity<CreateUserResponse> createUser(CreateUserRequest createUserRequest) {
        User user = mapper.fromDto(createUserRequest);
        user.setUserStatus(Status.ACTIVATE);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setUserPassword(encoder.encode(createUserRequest.getPassword()));
        repository.save(user);
        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setUserId(user.getUserId());
        createUserResponse.setMessage("User created successfully");

        return new ResponseEntity<>(createUserResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<GetAllUsersResponse>> getAllUsers() {
//        List<User> users = repository.findByUserStatusNot(Status.DELETE);
        List<User> users = repository.findAllUser(Status.DELETE);
        List<GetAllUsersResponse> responses = new ArrayList<>();

        for (User u : users) {
            GetAllUsersResponse gt = mapper.fromUser(u);
            responses.add(gt);
        }

        return new ResponseEntity<>(responses, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<String> deleteUser(Long id) {
        repository.deleteUserById(id, Status.DELETE);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Task>> getAllTaskForSpecificUser(Long id) {
        List<Task> tasks = taskRepository.findByUserUserId(id);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
