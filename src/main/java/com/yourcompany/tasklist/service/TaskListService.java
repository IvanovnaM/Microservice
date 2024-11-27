package com.yourcompany.tasklist.service;
import com.yourcompany.tasklist.dto.TaskListDTO;
import com.yourcompany.tasklist.model.TaskList;
import com.yourcompany.tasklist.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // методы для обновления, удаления и получения TaskList по ID
}
