package com.abhishek.task_management_api.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tags")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id", nullable = false, unique = true)
    private Long tagId;

    @Column(name = "tag_name", nullable = false)
    private String tagName;

    @ManyToMany(mappedBy = "tagSet")
    private Set<Task> taskSet;

}
