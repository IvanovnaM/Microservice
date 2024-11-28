package com.yourcompany.tasklist.service;
import com.yourcompany.tasklist.dto.TaskListDTO;
import com.yourcompany.tasklist.model.TaskList;
import com.yourcompany.tasklist.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskListService {
    @Autowired
    private TaskListRepository taskListRepository;

    public TaskListDTO createTaskList(TaskListDTO taskListDTO) {
        TaskList taskList = new TaskList();
        taskList.setName(taskListDTO.getName());
        taskListRepository.save(taskList);

        return new TaskListDTO(taskList.getTaskListId(), taskList.getName(), taskList.getCreatedAt(), taskList.getUpdatedAt());
    }

    public List<TaskListDTO> getAllTaskLists() {
        return taskListRepository.findAll().stream()
                .map(taskList -> new TaskListDTO(taskList.getTaskListId(), taskList.getName(), taskList.getCreatedAt(), taskList.getUpdatedAt()))
                .collect(Collectors.toList());
    }

    // Получение списка задач по ID
    public Optional<TaskList> getTaskListById(long taskListId) {
        return taskLists.stream().filter(taskList -> taskList.getTaskListId() == taskListId).findFirst();
    }

    // Обновление списка задач
    public Optional<TaskList> updateTaskList(long taskListId, String newName) {
        Optional<TaskList> taskListOpt = getTaskListById(taskListId);
        taskListOpt.ifPresent(taskList -> {
            taskList.setName(newName);
            taskList.setUpdatedAt(LocalDateTime.now());
        });
        return taskListOpt;
    }

    // Удаление списка задач
    public boolean deleteTaskList(long taskListId) {
        return taskLists.removeIf(taskList -> taskList.getTaskListId() == taskListId);
    }
}
