package com.Application.ToDoApp.service;

import com.Application.ToDoApp.model.Task;
import com.Application.ToDoApp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> GetAllTask() {
        return taskRepository.findAll();
    }

    public Task GetTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
