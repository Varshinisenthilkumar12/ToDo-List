package com.Application.ToDoApp.controller;


import com.Application.ToDoApp.model.Task;
import com.Application.ToDoApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("create")
    public ResponseEntity<Task> CreateTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @GetMapping("all")
    public ResponseEntity<List<Task>> GetAllTasks() {
        return ResponseEntity.ok(taskService.GetAllTask());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> GetTaskById(@PathVariable Long id) {
        Optional<Task> task = Optional.ofNullable(taskService.GetTaskById(id));
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> UpdateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Optional<Task> uTask = Optional.ofNullable(taskService.GetTaskById(id));
        if (uTask.isPresent()) {
            Task task = uTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
            return ResponseEntity.ok(taskService.saveTask(task));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable Long id) {
        Optional<Task> aLong= Optional.ofNullable(taskService.GetTaskById(id));
        if(aLong.isPresent()){
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
