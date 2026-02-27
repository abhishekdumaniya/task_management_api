package com.abhishek.task_management_api.controller;

import com.abhishek.task_management_api.domain.entities.Comment;
import com.abhishek.task_management_api.dto.commentdto.CreateCommentRequest;
import com.abhishek.task_management_api.dto.commentdto.CreateCommentResponse;
import com.abhishek.task_management_api.dto.tagdto.AssignTagResponse;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskRequest;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskResponse;
import com.abhishek.task_management_api.dto.taskdto.GetAllTaskResponse;
import com.abhishek.task_management_api.dto.taskdto.DeleteTaskResponse;
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

    @GetMapping("/{id}")
    public ResponseEntity<GetAllTaskResponse> getTaskById(@PathVariable Long id){
        return service.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteTaskResponse> deleteTask(@PathVariable Long id){
        return service.deleteTask(id);
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<CreateCommentResponse> createComment(@PathVariable Long id, @RequestBody CreateCommentRequest request){
        return service.createComment(id, request);
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<Comment>> getAllCommentForTask(@PathVariable Long id){
        return service.getAllCommentForTask(id);
    }

    @PostMapping("/{taskId}/tags/{tagId}")
    public ResponseEntity<AssignTagResponse> assignTagToTask(@PathVariable Long taskId, @PathVariable Long tagId){
        return service.assignTagToTask(taskId, tagId);
    }

}
