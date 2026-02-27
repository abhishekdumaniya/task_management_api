package com.abhishek.task_management_api.repository;

import com.abhishek.task_management_api.domain.entities.Comment;
import com.abhishek.task_management_api.domain.entities.Task;
import com.abhishek.task_management_api.domain.entities.User;
import com.abhishek.task_management_api.dto.taskdto.GetAllTaskResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserUserId(Long userId);
}
