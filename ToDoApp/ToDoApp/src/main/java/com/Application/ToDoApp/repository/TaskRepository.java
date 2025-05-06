package com.Application.ToDoApp.repository;

import com.Application.ToDoApp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
