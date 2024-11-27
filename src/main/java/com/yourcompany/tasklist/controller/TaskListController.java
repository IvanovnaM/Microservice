package com.yourcompany.tasklist.controller;
import com.yourcompany.tasklist.dto.TaskListDTO;
import com.yourcompany.tasklist.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasklists")
public class TaskListController {
    @Autowired
    private TaskListService taskListService;

    @PostMapping
    public TaskListDTO createTaskList(@RequestBody TaskListDTO taskListDTO) {
        return taskListService.createTaskList(taskListDTO);
    }

    @GetMapping
    public List<TaskListDTO> getAllTaskLists() {
        return taskListService.getAllTaskLists();
    }
    // Методы для получения, обновления и удаления TaskList по ID
}
