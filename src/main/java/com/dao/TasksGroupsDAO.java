package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import com.model.TasksGroups;
public class TasksGroupsDAO {
    @Autowired
    EntityManagerFactory emf;
    public TasksGroupsDAO(EntityManagerFactory emf){
        this.emf = emf;
    }
    public List<TasksGroups> getAllTasksGroups() {
        EntityManager  em = emf.createEntityManager();
        List<TasksGroups> taskList = em.createQuery("from Task", TasksGroups.class).getResultList();
        return taskList;
        
    }
}
