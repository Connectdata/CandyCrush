package common.model.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import configuration.InfoProject;
import helper.ClassHelper;
@Service
public class SessionFactoryHelper
{
    
    @Bean
    private SessionFactory sessionFactory() 
    {
        try {
            Configuration configuration = getConfiguration();
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    private Configuration getConfiguration() throws ClassNotFoundException{
        Configuration configuration=new Configuration();
        configuration.configure();
        configuration.setProperty("hibernate.connection.url", InfoProject.getJDBCUrl());
        configuration.setProperty("hibernate.connection.username", InfoProject.getDatabaseUser());
        configuration.setProperty("hibernate.connection.password", InfoProject.getDatabasePassword());

        for(Class c:ClassHelper.getClasses("model.mapping"))
        {
            try 
            {
                configuration.addAnnotatedClass(c.newInstance().getClass());
            } 
            catch (Exception e)
            {
                
            } 
            
        }
        return configuration;
    }
}
