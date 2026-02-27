package com.abhishek.task_management_api.dto.taskdto;

import com.abhishek.task_management_api.domain.entities.Comment;
import com.abhishek.task_management_api.domain.entities.Tag;
import com.abhishek.task_management_api.dto.userdto.GetAllUsersResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTaskResponse {
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private GetAllUsersResponse user;
    private List<Comment> comments;
    private Set<Tag> tags;
}
