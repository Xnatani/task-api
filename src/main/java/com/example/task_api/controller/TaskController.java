package com.example.task_api.controller;

import com.example.task_api.module.Task;
import com.example.task_api.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable long id) {
        return taskRepository.findById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody Task updateTask) {
        updateTask.setId(id);
        return taskRepository.save(updateTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
        taskRepository.delete(id);
    }
}