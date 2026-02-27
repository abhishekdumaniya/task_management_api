package com.abhishek.task_management_api.dto.taskdto;

import lombok.Data;

@Data
public class DeleteTaskResponse {
    private String message;
    private Long id;
}
