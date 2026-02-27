package com.abhishek.task_management_api.dto.tagdto;

import com.abhishek.task_management_api.domain.entities.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignTagResponse {

    private Long id;
    private String title;
    private List<CreateTagResponse> tags;

}
