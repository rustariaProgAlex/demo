package com.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dao.ProjectDAO;
import com.dao.TaskDAO;
import com.dao.TasksGroupsDAO;
import com.dao.UserDAO;
import com.model.Task;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    // @Bean
    // public LocalSessionFactoryBean sessionFactory() {
    //     LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    //     sessionFactory.setDataSource(dataSource());
    //     sessionFactory.setPackagesToScan("com.baeldung.hibernate.bootstrap.model");
    //     sessionFactory.setHibernateProperties(hibernateProperties());

    //     return sessionFactory;
    // }

    @Bean
    public DataSource dataSource() {
    
        return DataSourceBuilder.create()
                .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .url("jdbc:sqlserver://localhost:1433;databaseName=Tasks;encrypt=true;trustServerCertificate=true")
                .username("root")
                .password("123456789")
                .build();
         
    }

    // @Bean
    // public PlatformTransactionManager hibernateTransactionManager() {
    //     HibernateTransactionManager transactionManager
    //       = new HibernateTransactionManager();
    //     transactionManager.setSessionFactory();
    //     return transactionManager;
    // }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", "validate");
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");

        return hibernateProperties;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.model");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());
        return em;
    }
    @Bean 
    public UserDAO userDao(){
        return new UserDAO(entityManagerFactory(dataSource()).getObject());
    }
    @Bean
    public TaskDAO taskDAO(){
        return new TaskDAO(entityManagerFactory(dataSource()).getObject());
    }
    @Bean
    public ProjectDAO projectDAO(){
        return new ProjectDAO(entityManagerFactory(dataSource()).getObject());
    }
    @Bean
    public TasksGroupsDAO tasksGroupsDAO(){
        return new TasksGroupsDAO(entityManagerFactory(dataSource()).getObject());
    }

}