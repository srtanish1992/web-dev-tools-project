package com.neu.project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.UserException;
import com.neu.project.pojo.AllUsers;
import com.neu.project.pojo.Email;


public class UserDAO extends DAO {

	public UserDAO() {
	}

	public List<AllUsers> getAllUsers() throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from AllUsers");
			List<AllUsers> users = (List<AllUsers>) q.list();
			commit();
			return users;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user ", e);
		}
	}

	public AllUsers get(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from AllUsers where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			AllUsers user = (AllUsers) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}

	public AllUsers getUserFromUserName(String username) throws UserException {

		try {
			begin();
			Query q = getSession().createQuery("from AllUsers where username = :username");
			q.setString("username", username);
			AllUsers user = (AllUsers) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}

	public AllUsers get(Long userId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from AllUsers where userId= :userId");
			q.setLong("userId", userId);
			AllUsers user = (AllUsers) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + userId, e);
		}
	}

	public List<AllUsers> getUsersByRole(String role) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from AllUsers where role= :role");
			q.setString("role", role);
			List<AllUsers> users = (List<AllUsers>) q.list();
			commit();
			return users;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + role, e);
		}
	}

	public AllUsers register(AllUsers u) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			Email email = new Email(u.getEmail().getEmailAddress());
			AllUsers user = new AllUsers(u.getUserName(), u.getPassword());
			user.setFilename(u.getFilename());
			user.setFirstName(u.getFirstName());
			user.setLastName(u.getLastName());
			user.setEmail(email);
			user.setCity(u.getCity());
			user.setState(u.getState());
			user.setAddress(u.getAddress());
			user.setMiddleName(u.getMiddleName());
			user.setPhoneNumber(u.getPhoneNumber());
			user.setRole(u.getRole());
			email.setUser(user);
			getSession().save(user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(AllUsers user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getUserName(), e);
		}
	}
}