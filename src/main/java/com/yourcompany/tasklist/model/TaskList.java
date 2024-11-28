package com.yourcompany.tasklist.model;

import jakarta.persistence.*;
import org.springframework.scheduling.config.Task;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "task_lists")

public class TaskList {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_list_id")
    private Long taskListId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public TaskList(Long taskListId, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.taskListId = taskListId;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(Long taskListId) {
        this.taskListId = taskListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
