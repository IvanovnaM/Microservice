package com.yourcompany.tasklist.dto;
import java.time.LocalDateTime;
public class TaskDTO {
    private Long taskId;
    private Long taskListId;
    private String title;
    private String description;
    private String status;
    private String priority;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // constructors, getters and setters
}
