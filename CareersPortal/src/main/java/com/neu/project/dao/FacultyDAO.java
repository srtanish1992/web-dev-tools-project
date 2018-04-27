package com.neu.project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.UserException;
import com.neu.project.pojo.AllUsers;
import com.neu.project.pojo.Email;
import com.neu.project.pojo.Employer;
import com.neu.project.pojo.Faculty;

public class FacultyDAO extends DAO {
	
	public FacultyDAO() {

	}

	public void register(Faculty faculty) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			getSession().save(faculty);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating employee: " + e.getMessage());
		}
	}
	
	public Faculty getfacultyByUserId(AllUsers u) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Faculty where facultyId = :facultyId");
			q.setLong("facultyId", u.getUserId());
			Faculty faculty = (Faculty) q.uniqueResult();
			commit();
			return faculty;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get employer " + u.getFirstName(), e);
		}

	}

	public List<Faculty> getfaculty() throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Faculty");
//			Faculty faculty = (Faculty) q.setMaxResults(1).uniqueResult();
			List<Faculty> faculty = (List<Faculty>) q.list();
			commit();
			return faculty;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get employer " + e.getMessage());
		}
	}

	public Faculty getfacultyByEmployerId(Long em) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Faculty where facultyId = :facultyId");
			q.setLong("facultyId", em);
			Faculty faculty = (Faculty) q.uniqueResult();
			commit();
			return faculty;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get employer ", e);
		}
	}
	
}
