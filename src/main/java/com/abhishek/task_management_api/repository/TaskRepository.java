package com.abhishek.task_management_api.repository;

import com.abhishek.task_management_api.domain.entities.Task;
import com.abhishek.task_management_api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
