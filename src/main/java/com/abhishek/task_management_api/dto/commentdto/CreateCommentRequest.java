package com.abhishek.task_management_api.dto.commentdto;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private String text;
    private Long id;
}
