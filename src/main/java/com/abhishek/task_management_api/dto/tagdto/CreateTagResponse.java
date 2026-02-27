package com.abhishek.task_management_api.dto.tagdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTagResponse {
    private String name;
    private Long id;
}
