package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Projects;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ProjectDAO {
    @Autowired
    EntityManagerFactory emf;
    public ProjectDAO(EntityManagerFactory emf){
        this.emf = emf;
    }
    public List<Projects> getAllProjects() {
        EntityManager  em = emf.createEntityManager();
        List<Projects> projectList = em.createQuery("from Projects", Projects.class).getResultList();
        return projectList;
    }  
   public List<Projects> getProjectById(Long id) {
       EntityManager  em = emf.createEntityManager();
       List<Projects> projectList = em.createQuery("from Projects where id = :id", Projects.class).setParameter("id", id).getResultList();
       return projectList;
   } 
    public List<Projects> getProjectsUserById(Long userId) {
        EntityManager em = emf.createEntityManager();
        List<Projects> projectList = em.createQuery("from Projects where executor = :userId", Projects.class).setParameter("userId", userId).getResultList();
        em.close();
        return projectList;
    }
}
