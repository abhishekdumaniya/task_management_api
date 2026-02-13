package com.abhishek.task_management_api.mapper.taskmapper;

import com.abhishek.task_management_api.domain.entities.Task;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskRequest;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskResponse;
import com.abhishek.task_management_api.dto.taskdto.GetAllTaskResponse;

public interface TaskMapper {

    Task fromDto(CreateTaskRequest createTaskRequest);
    CreateTaskResponse fromCreateTaskRequest(CreateTaskRequest createTaskRequest);
    GetAllTaskResponse fromTask(Task task);
}
