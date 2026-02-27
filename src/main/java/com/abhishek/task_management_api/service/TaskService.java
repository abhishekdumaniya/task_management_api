package com.abhishek.task_management_api.service;

import com.abhishek.task_management_api.domain.entities.Comment;
import com.abhishek.task_management_api.dto.commentdto.CreateCommentRequest;
import com.abhishek.task_management_api.dto.commentdto.CreateCommentResponse;
import com.abhishek.task_management_api.dto.tagdto.AssignTagResponse;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskRequest;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskResponse;
import com.abhishek.task_management_api.dto.taskdto.GetAllTaskResponse;
import com.abhishek.task_management_api.dto.taskdto.DeleteTaskResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    ResponseEntity<CreateTaskResponse> createTask(CreateTaskRequest request);

    ResponseEntity<List<GetAllTaskResponse>> getAllTask();

    ResponseEntity<GetAllTaskResponse> getTaskById(Long id);

    ResponseEntity<DeleteTaskResponse> deleteTask(Long id);

    ResponseEntity<CreateCommentResponse> createComment(Long id, CreateCommentRequest request);

    ResponseEntity<List<Comment>> getAllCommentForTask(Long id);

    ResponseEntity<AssignTagResponse> assignTagToTask(Long taskId, Long tagId);
}
