package com.yourcompany.tasklist.controller;
import com.yourcompany.tasklist.dto.TaskDTO;
import com.yourcompany.tasklist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasklists/{taskListId}/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskDTO createTask(@PathVariable Long taskListId, @RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskListId, taskDTO);
    }

    @GetMapping
    public List<TaskDTO> getAllTasks(@PathVariable Long taskListId) {
        return taskService.getAllTasks(taskListId);
    }

    // Методы для получения, обновления и удаления задачи
}
