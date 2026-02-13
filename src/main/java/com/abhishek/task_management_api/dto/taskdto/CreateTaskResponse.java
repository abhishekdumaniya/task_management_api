package com.abhishek.task_management_api.dto.taskdto;

import com.abhishek.task_management_api.domain.entities.Tag;
import com.abhishek.task_management_api.domain.entities.User;
import com.abhishek.task_management_api.dto.userdto.GetAllUsersResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class CreateTaskResponse {

    private Long id;
    private String title;
    private String description;
    private String status;
    private GetAllUsersResponse user;
    private List<Tag> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
