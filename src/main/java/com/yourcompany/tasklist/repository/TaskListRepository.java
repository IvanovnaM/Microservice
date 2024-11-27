package com.yourcompany.tasklist.repository;

import com.yourcompany.tasklist.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TaskListRepository extends JpaRepository<TaskList, Long>{
}
