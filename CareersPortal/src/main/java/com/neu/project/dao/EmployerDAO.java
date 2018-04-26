package com.neu.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.UserException;
import com.neu.project.pojo.AllUsers;
import com.neu.project.pojo.Email;
import com.neu.project.pojo.Employer;

public class EmployerDAO extends DAO {

	public EmployerDAO() {

	}

	public Employer register(Employer employer) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

//			Employer emp = new Employer();
//			emp.setIndustry(employer.getIndustry());
//			emp.setOrganizationName(employer.getOrganizationName());
//			AllUsers users = new AllUsers(employer.getUser().getUserName(), employer.getUser().getPassword());
//			users.setAddress(employer.getUser().getAddress());
//			users.setCity(employer.getUser().getCity());
////			Email email = new Email();
////			email.setEmailAddress(employer.getUser().getEmail().getEmailAddress());
//			users.setEmail(employer.getUser().getEmail());
//			users.setFilename(employer.getUser().getFilename());
//			users.setFirstName(employer.getUser().getFirstName());
//			users.setLastName(employer.getUser().getLastName());
//			users.setMiddleName(employer.getUser().getMiddleName());
//			users.setPassword(employer.getUser().getPassword());
//			users.setPhoneNumber(employer.getUser().getPhoneNumber());
//			users.setPhoto(employer.getUser().getPhoto());
//			users.setRole("Employer");
//			users.setState(employer.getUser().getState());
//			users.setUserName(employer.getUser().getUserName());
//			emp.setUser(users);
			getSession().save(employer);
			commit();
			return employer;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating employee: " + e.getMessage());
		}
	}
	
	
	
//	public Employer registerFromJsp(Employer employer) throws UserException {
//		try {
//			begin();
//			System.out.println("inside DAO");
//
//			Employer emp = new Employer();
//			emp.setIndustry(employer.getIndustry());
//			emp.setOrganizationName(employer.getOrganizationName());
//			AllUsers users = new AllUsers(employer.getUser().getUserName(), employer.getUser().getPassword());
//			users.setAddress(employer.getUser().getAddress());
//			users.setCity(employer.getUser().getCity());
//			Email email = new Email();
//			email.setEmailAddress(employer.getUser().getEmail().getEmailAddress());
//			users.setEmail(employer.getUser().getEmail());
//			users.setFilename(employer.getUser().getFilename());
//			users.setFirstName(employer.getUser().getFirstName());
//			users.setLastName(employer.getUser().getLastName());
//			users.setMiddleName(employer.getUser().getMiddleName());
//			users.setPassword(employer.getUser().getPassword());
//			users.setPhoneNumber(employer.getUser().getPhoneNumber());
//			users.setPhoto(employer.getUser().getPhoto());
//			users.setRole("Employer");
//			users.setState(employer.getUser().getState());
//			users.setUserName(employer.getUser().getUserName());
//			emp.setUser(users);
//			getSession().save(employer);
//			commit();
//			return employer;
//
//		} catch (HibernateException e) {
//			rollback();
//			throw new UserException("Exception while creating employee: " + e.getMessage());
//		}
//	}

	public Employer getEmployerByUserId(AllUsers u) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Employer where employerId = :employerId");
			q.setLong("employerId", u.getUserId());
			Employer employer = (Employer) q.uniqueResult();
			commit();
			return employer;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get employer " + u.getFirstName(), e);
		}

	}

	public Employer getEmployerByEmployerId(Long employerId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Employer where employerId = :employerId");
			q.setLong("employerId", employerId);
			Employer employer = (Employer) q.uniqueResult();
			commit();
			return employer;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get employer ", e);
		}
	}

}
