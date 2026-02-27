package com.abhishek.task_management_api.controller;

import com.abhishek.task_management_api.domain.entities.Task;
import com.abhishek.task_management_api.dto.userdto.CreateUserRequest;
import com.abhishek.task_management_api.dto.userdto.CreateUserResponse;
import com.abhishek.task_management_api.dto.userdto.GetAllUsersResponse;
import com.abhishek.task_management_api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest){
        return service.createUser(createUserRequest);
    }

    @GetMapping
    public ResponseEntity<List<GetAllUsersResponse>> getAllUsers(){
        return service.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return service.deleteUser(id);
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<Task>> getAllTaskForSpecificUser(@PathVariable Long id){
        return service.getAllTaskForSpecificUser(id);
    }


}
