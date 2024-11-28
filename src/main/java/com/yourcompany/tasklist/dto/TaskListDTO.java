package com.yourcompany.tasklist.dto;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
public class TaskListDTO {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private Long taskListId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // constructors, getters and setters
}
