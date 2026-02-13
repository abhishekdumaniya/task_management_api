package com.abhishek.task_management_api.mapper.taskmapper.impl;

import com.abhishek.task_management_api.domain.entities.Task;
import com.abhishek.task_management_api.domain.entities.User;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskRequest;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskResponse;
import com.abhishek.task_management_api.dto.taskdto.GetAllTaskResponse;
import com.abhishek.task_management_api.mapper.taskmapper.TaskMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public Task fromDto(CreateTaskRequest createTaskRequest) {
        return new Task(
                null,
                createTaskRequest.getTitle(),
                createTaskRequest.getDescription(),
                createTaskRequest.getStatus(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                null,
                null,
                null
        );
    }

    @Override
    public CreateTaskResponse fromCreateTaskRequest(CreateTaskRequest createTaskRequest) {
        return new CreateTaskResponse(
                createTaskRequest.getUserId(),
                createTaskRequest.getTitle(),
                createTaskRequest.getDescription(),
                createTaskRequest.getStatus(),
                null,
                null,
                null,
                null
        );
    }

    @Override
    public GetAllTaskResponse fromTask(Task task) {
        return new GetAllTaskResponse(
                task.getTaskId(),
                task.getTaskTitle(),
                task.getTaskDescription(),
                task.getTaskStatus(),
                task.getCreatedAt(),
                task.getUpdatedAt(),
                null,
                task.getCommentList(),
                task.getTagSet()
        );
    }
}
