package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Projects;
import com.dao.ProjectDAO;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectDAO projectDao;

    @GetMapping("/")
    public List<Projects> getAllProjects() {
        return projectDao.getAllProjects();
    }
    //Как я тебя учил, всегда начинай с верхнего уровня, потом по нарастающей вниз
    //Куда то там в запросы полез
    @GetMapping("/{id}")
    public List<Projects> getProjectById(@PathVariable Long id) {
        return projectDao.getProjectById(id);
    }
    
}
