package com.abhishek.task_management_api.service.impl;

import com.abhishek.task_management_api.domain.entities.Task;
import com.abhishek.task_management_api.domain.entities.User;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskRequest;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskResponse;
import com.abhishek.task_management_api.dto.taskdto.GetAllTaskResponse;
import com.abhishek.task_management_api.dto.userdto.GetAllUsersResponse;
import com.abhishek.task_management_api.mapper.taskmapper.TaskMapper;
import com.abhishek.task_management_api.mapper.usermapper.UserMapper;
import com.abhishek.task_management_api.repository.TaskRepository;
import com.abhishek.task_management_api.repository.UserRepository;
import com.abhishek.task_management_api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final UserRepository userRepository;
    private final TaskRepository repository;
    private final UserMapper userMapper;
    private final TaskMapper mapper;

    @Override
    public ResponseEntity<CreateTaskResponse> createTask(CreateTaskRequest request) {
        Task task = mapper.fromDto(request);
        User user = userRepository.findByUserId(request.getUserId());
        GetAllUsersResponse res = userMapper.fromUser(user);
        task.setUser(user);
        repository.save(task);

        CreateTaskResponse response = mapper.fromCreateTaskRequest(request);
        response.setUser(res);
        response.setCreatedAt(task.getCreatedAt());
        response.setUpdatedAt(task.getUpdatedAt());
        response.setTags(new ArrayList<>());

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<List<GetAllTaskResponse>> getAllTask() {
        List<Task> taskList = repository.findAll();
        List<GetAllTaskResponse> responsesList = new ArrayList<>();

        for (Task task : taskList){
            GetAllTaskResponse res = mapper.fromTask(task);
            if (task.getUser() != null){
                GetAllUsersResponse usersResponse = userMapper.fromUser(task.getUser());
                res.setUser(usersResponse);
            } else{
                res.setUser(null);
            }
            responsesList.add(res);
        }
        return new ResponseEntity<>(responsesList, HttpStatus.OK);
    }

}
