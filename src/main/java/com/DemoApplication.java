package com;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.configuration.HibernateConfig;
import com.dao.ProjectDAO;
import com.dao.UserDAO;
import com.model.User;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner  {
	@Autowired
    private UserDAO userDao;
	@Autowired
    private ProjectDAO projectDao;
	public static void main(String[] args) {
		
		SpringApplication.run(DemoApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		User user = userDao.getAllUsers().get(0);
		user.setFirstName("Jopa");
		System.out.println(projectDao.getAllProjects().get(0));
		System.out.println(projectDao.getProjectById(1l));
		//wse rabotaet
		//zaebal opat v glaza dolbishsya
		// a cho ne tak balo 

	}


}
