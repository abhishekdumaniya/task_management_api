package com.abhishek.task_management_api.repository;

import com.abhishek.task_management_api.domain.entities.User;
import com.abhishek.task_management_api.domain.enums.Status;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.userStatus = :status WHERE u.userId = :id")
    void deleteUserById(@Param("id") Long id, @Param("status") Status status);

    @Query("SELECT u FROM User u WHERE u.userStatus <> :status")
    List<User> findAllUser(@Param("status") Status status);
    List<User> findByUserStatusNot(Status status);


    User findByUserId(Long userId);
}
