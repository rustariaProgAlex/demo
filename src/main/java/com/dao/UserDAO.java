package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;

public class UserDAO {
    @Autowired
    private EntityManagerFactory emf;
    public UserDAO(EntityManagerFactory emf){
        this.emf = emf;
    }
    public List<User> getAllUsers(){
        EntityManager em =  emf.createEntityManager();
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return users;
    
    }
    @Transactional
    public User getUserById(Long id){
        EntityManager  em = emf.createEntityManager();
        List<User> userList = em.createQuery("from User where id = :id", User.class).setParameter("id", id).getResultList();
        em.close();

        return userList.get(0);
    }
    // void addUser(User user);
    // void updateUser(User user);
    // void deleteUser(int id);
}
