package com.yourcompany.tasklist.repository;
import com.yourcompany.tasklist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTaskListTaskListId(Long taskListId);
    List<Task> findByTaskListTaskListIdAndStatus(Long taskListId, String status);
    List<Task> findByTaskListTaskListIdAndPriority(Long taskListId, String priority);
}
