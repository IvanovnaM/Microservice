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
    // Получение списка задач по ID
    @GetMapping("/{taskListId}")
    public ResponseEntity<TaskList> getTaskListById(@PathVariable long taskListId) {
        Optional<TaskList> taskList = taskListService.getTaskListById(taskListId);
        return taskList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Обновление списка задач
    @PutMapping("/{taskListId}")
    public ResponseEntity<TaskList> updateTaskList(@PathVariable long taskListId, @RequestBody TaskList taskList) {
        Optional<TaskList> updatedTaskList = taskListService.updateTaskList(taskListId, taskList.getName());
        return updatedTaskList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Удаление списка задач
    @DeleteMapping("/{taskListId}")
    public ResponseEntity<Void> deleteTaskList(@PathVariable long taskListId) {
        boolean isDeleted = taskListService.deleteTaskList(taskListId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
