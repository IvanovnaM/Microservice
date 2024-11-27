package com.yourcompany.tasklist.service;
import com.yourcompany.tasklist.dto.TaskDTO;
import com.yourcompany.tasklist.model.Task;
import com.yourcompany.tasklist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service

public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskDTO createTask(Long taskListId, TaskDTO taskDTO) {
        Task task = new Task();
        task.setTaskList(new TaskList(taskListId)); // Сюда добавляется связь с TaskList
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setPriority(taskDTO.getPriority());
        task.setStatus("TODO");
        task.setDueDate(taskDTO.getDueDate());
        taskRepository.save(task);

        return new TaskDTO(task.getTaskId(), task.getTaskList().getTaskListId(), task.getTitle(), task.getDescription(), task.getStatus(), task.getPriority(), task.getDueDate(), task.getCreatedAt(), task.getUpdatedAt());
    }

    public List<TaskDTO> getAllTasks(Long taskListId) {
        return taskRepository.findByTaskListTaskListId(taskListId).stream()
                .map(task -> new TaskDTO(task.getTaskId(), task.getTaskList().getTaskListId(), task.getTitle(), task.getDescription(), task.getStatus(), task.getPriority(), task.getDueDate(), task.getCreatedAt(), task.getUpdatedAt()))
                .collect(Collectors.toList());
    }
// Методы для обновления, удаления задач и фильтрации по статусу и приоритету
}
