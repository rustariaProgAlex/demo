package com.dao;

import java.security.spec.ECFieldFp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Task;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class TaskDAO {
    @Autowired
    EntityManagerFactory emf;
    public TaskDAO(EntityManagerFactory emf){
        this.emf = emf;
    }
    public List<Task> getAllTasks() {
        EntityManager  em = emf.createEntityManager();
        List<Task> taskList = em.createQuery("from Task", Task.class).getResultList();
        return taskList;
        
    }
    public List<Task> getTasksByUserId(Long userId) {
        EntityManager  em = emf.createEntityManager();
        List<Task> taskList = em.createQuery("from Task where executor = :userId", Task.class).setParameter("userId", userId).getResultList();
        return taskList;
    }
    public List<Task> getTasksById(Long id) {
        EntityManager  em = emf.createEntityManager();
        List<Task> taskList = em.createQuery("from Task where id = :id", Task.class).setParameter("id", id).getResultList();
        return taskList;
    }
}
