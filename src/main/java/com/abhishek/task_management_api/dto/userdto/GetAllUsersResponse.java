package com.abhishek.task_management_api.dto.userdto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAllUsersResponse {
    private Long userId;
    private String userName;
    private String userEmail;
}
