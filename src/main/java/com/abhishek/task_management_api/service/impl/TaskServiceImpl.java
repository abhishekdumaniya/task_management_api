package com.abhishek.task_management_api.service.impl;

import com.abhishek.task_management_api.domain.entities.Comment;
import com.abhishek.task_management_api.domain.entities.Tag;
import com.abhishek.task_management_api.domain.entities.Task;
import com.abhishek.task_management_api.domain.entities.User;
import com.abhishek.task_management_api.dto.commentdto.CreateCommentRequest;
import com.abhishek.task_management_api.dto.commentdto.CreateCommentResponse;
import com.abhishek.task_management_api.dto.tagdto.AssignTagResponse;
import com.abhishek.task_management_api.dto.tagdto.CreateTagResponse;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskRequest;
import com.abhishek.task_management_api.dto.taskdto.CreateTaskResponse;
import com.abhishek.task_management_api.dto.taskdto.GetAllTaskResponse;
import com.abhishek.task_management_api.dto.taskdto.DeleteTaskResponse;
import com.abhishek.task_management_api.dto.userdto.GetAllUsersResponse;
import com.abhishek.task_management_api.mapper.commentmapper.CommentMapper;
import com.abhishek.task_management_api.mapper.taskmapper.TaskMapper;
import com.abhishek.task_management_api.mapper.usermapper.UserMapper;
import com.abhishek.task_management_api.repository.CommentRepository;
import com.abhishek.task_management_api.repository.TagRepository;
import com.abhishek.task_management_api.repository.TaskRepository;
import com.abhishek.task_management_api.repository.UserRepository;
import com.abhishek.task_management_api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;
    private final UserMapper userMapper;
    private final TaskMapper mapper;
    private final CommentMapper commentMapper;

    @Override
    public ResponseEntity<CreateTaskResponse> createTask(CreateTaskRequest request) {
        Task task = mapper.fromDto(request);
        User user = userRepository.findByUserId(request.getUserId());
        GetAllUsersResponse res = userMapper.fromUser(user);
        task.setUser(user);
        taskRepository.save(task);

        CreateTaskResponse response = mapper.fromCreateTaskRequest(request);
        response.setUser(res);
        response.setCreatedAt(task.getCreatedAt());
        response.setUpdatedAt(task.getUpdatedAt());
        response.setTags(new ArrayList<>());

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<List<GetAllTaskResponse>> getAllTask() {
        List<Task> taskList = taskRepository.findAll();
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

    @Override
    public ResponseEntity<GetAllTaskResponse> getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Task task = optionalTask.get();
        GetAllTaskResponse response = mapper.fromTask(task);

        if (task.getUser() != null){
            GetAllUsersResponse usersResponse = userMapper.fromUser(task.getUser());
            response.setUser(usersResponse);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DeleteTaskResponse> deleteTask(Long id) {

        boolean check = taskRepository.existsById(id);
        if (check){
            taskRepository.deleteById(id);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        DeleteTaskResponse response = new DeleteTaskResponse();
        response.setMessage("Delete task successfully");
        response.setId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateCommentResponse> createComment(Long id, CreateCommentRequest request) {

        if (id == null || request.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Task> taskOpt = taskRepository.findById(id);
        if (taskOpt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<User> userOpt = userRepository.findById(request.getId());
        GetAllUsersResponse usersResponse = userMapper.fromUser(userOpt.get());
        if (userOpt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Comment comment = commentMapper.fromComment(request);
        comment.setTask(taskOpt.get());
        comment.setUser(userOpt.get());

        commentRepository.save(comment);

        CreateCommentResponse response = new CreateCommentResponse();
        response.setId(request.getId());
        response.setText(request.getText());
        response.setUser(usersResponse);
        response.setCreatedAt(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Comment>> getAllCommentForTask(Long id) {
        List<Comment> comments = commentRepository.findByTaskTaskId(id);
        if (comments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(comments, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<AssignTagResponse> assignTagToTask(Long taskId, Long tagId) {

        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<Tag> tagOptional = tagRepository.findById(tagId);
        if (tagOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Task task = taskOptional.get();
        Tag tag = tagOptional.get();

        // Assuming Many-to-Many relation and Task has Set<Tag> tags
//        task.getTags().add(tag);
        task.getTagSet().add(tag);

        Task savedTask = taskRepository.save(task);

        // Build response
        AssignTagResponse response = new AssignTagResponse();
        response.setId(savedTask.getTaskId());
        response.setTitle(savedTask.getTaskTitle());
        List<CreateTagResponse> tags = new ArrayList<>();

        for (Tag tag1 : savedTask.getTagSet()){
            CreateTagResponse cr = new CreateTagResponse();
            cr.setName(tag1.getTagName());
            cr.setId(tag1.getTagId());
            tags.add(cr);
        }

        response.setTags(tags);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
