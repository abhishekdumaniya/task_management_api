package com.abhishek.task_management_api.service;

import com.abhishek.task_management_api.domain.entities.Task;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskRequest;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskResponse;
import com.abhishek.task_management_api.dto.taskdto.GetAllTaskResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    ResponseEntity<CreateTaskResponse> createTask(CreateTaskRequest request);

    ResponseEntity<List<GetAllTaskResponse>> getAllTask();
}
