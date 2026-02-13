package com.abhishek.task_management_api.controller;

import com.abhishek.task_management_api.domain.entities.Task;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskRequest;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskResponse;
import com.abhishek.task_management_api.dto.taskdto.GetAllTaskResponse;
import com.abhishek.task_management_api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public ResponseEntity<CreateTaskResponse> createTask(@RequestBody CreateTaskRequest request){
        return service.createTask(request);
    }

    @GetMapping
    public ResponseEntity<List<GetAllTaskResponse>> getAllTask(){
        return service.getAllTask();
    }

}
