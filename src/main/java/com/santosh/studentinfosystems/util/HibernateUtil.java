package com.santosh.studentinfosystems.util;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.santosh.studentinfosystems.dto.User;

public class HibernateUtil {

	public static Session getSession() {
		Session session = null;
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
			Configuration config = new Configuration();
			config.setProperties(props);
			config.addAnnotatedClass(User.class);
			StandardServiceRegistry sRegistry = new StandardServiceRegistryBuilder()
					.applySettings(config.getProperties()).build();
			SessionFactory sessionFactory = config.buildSessionFactory(sRegistry);
			session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
