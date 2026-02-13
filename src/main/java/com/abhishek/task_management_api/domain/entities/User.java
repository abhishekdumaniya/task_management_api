package com.abhishek.task_management_api.domain.entities;

import com.abhishek.task_management_api.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false)
    private Status userStatus;

    @Column(name = "created-_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "uodated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Task> taskList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> commentList;

}
