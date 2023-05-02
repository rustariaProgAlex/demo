package com.controller;

import java.util.List;
import com.dao.TasksGroupsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.TasksGroups;
@RestController
public class TaskGroupController {
    @Autowired
    private TasksGroupsDAO taskGroupDAO;

    @GetMapping("/taskgroup")
    public List<TasksGroups> getAllTaskGroup() {
        return taskGroupDAO.getAllTasksGroups();
    }
}
