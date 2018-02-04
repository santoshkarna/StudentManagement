package com.santosh.studentinfosystems.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.santosh.studentinfosystems.dto.User;
import com.santosh.studentinfosystems.util.DbUtil;
import com.santosh.studentinfosystems.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	PreparedStatement ps = null;

	@Override
	public void saveUserInfo(User user) {
		Session session = HibernateUtil.getSession();
		session.save(user);
		session.getTransaction().commit();
	}

	@Override
	public void updateUserInfo(User user) {
		Session session = HibernateUtil.getSession();
		session.update(user);
		session.getTransaction().commit();
	}

	@Override
	public void deleteUserInfo(int id) {
		User user = getUserInfoById(id);
		if (user != null) {
			Session session = HibernateUtil.getSession();
			session.delete(user);
			session.getTransaction().commit();
		}
	}

	@Override
	public List<User> getAllUserInfo() {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(User.class);
		List<User> userList = criteria.list();
		session.getTransaction().commit();
		return userList;
	}

	@Override
	public User getUserInfoById(int id) {
		Session session = HibernateUtil.getSession();
		User user= session.get(User.class, id);
		session.getTransaction().commit();
		return user;
	}

	@Override
	public String getImageUrl(int id) {
		User user = getUserInfoById(id);
		return user.getImageUrl();
	}

	@Override
	public int checkUser(String userName, String password) {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName)).add(Restrictions.eq("password", password));
		User user = (User) criteria.uniqueResult();
		session.getTransaction().commit();
		return user.getId();
	}

	@Override
	public User checkEmail(String email) {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(User.class);
		User user = (User) criteria.add(Restrictions.eq("email", email)).uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	
}
