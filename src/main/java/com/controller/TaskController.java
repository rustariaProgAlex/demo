package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dao.TaskDAO;
import com.model.Task;

import jakarta.persistence.Id;

@RestController
public class TaskController {
    @Autowired
    private TaskDAO taskDAO;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }
    @GetMapping("/tasks/{id}")
    public List<Task> getTasksById(@PathVariable Long id) {
        return taskDAO.getTasksById(id);
    }

    // other methods
}