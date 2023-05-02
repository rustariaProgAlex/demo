package com.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ProjectDAO;
import com.dao.TaskDAO;
import com.dao.UserDAO;
import com.model.Task;
import com.model.User;
import com.model.Projects;
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private TaskDAO taskDAO;
    @Autowired
    private ProjectDAO projectDAO;
    @GetMapping("/")
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @GetMapping("/{id}/tasks")
    public List<Task> getTasksByUserId(@PathVariable Long id) {
        return taskDAO.getTasksByUserId(userDao.getUserById(id).getId());
    }
    @RequestMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userDao.getUserById(id);
    }
    @CrossOrigin
    @GetMapping("/{id}/projects")
    public CompletableFuture<List<Projects>> getProjectsByUserId(@PathVariable Long id) {
        return CompletableFuture.supplyAsync(() -> {        
            return projectDAO.getProjectsUserById(userDao.getUserById(id).getId());
        });
    }
    // other methods
}