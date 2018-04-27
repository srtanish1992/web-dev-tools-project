package com.neu.project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.UserException;
import com.neu.project.pojo.Job;
import com.neu.project.pojo.Student;

public class StudentDAO extends DAO {

	public StudentDAO() {

	}

	public Student register(Student s) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(s);
			commit();
            return s;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public Student getStudentByStudentId(Long sId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Student where studentId = :studentId");
			q.setLong("studentId", sId);
			Student student = (Student) q.uniqueResult();
			commit();
			return student;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get student studentdao " + sId, e);
		}
	}

	public void updateStudent(Student student) throws UserException {
		try {
			begin();
			System.out.println("inside student DAO");

			getSession().merge(student);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while updating student studentdao: " + e.getMessage());
		}
	}

//	public Set<Job> getJobsByQuery(String query, String searchType) throws UserException {
//		try {
//			begin();
//			List<Job> jobs = new ArrayList<Job>();
//			if(searchType.equals("jobName")){
//				Query q = getSession().createQuery("from Job where jobName= :query");
//				q.setString("query", query);
//				jobs = q.list();
//	        }else if(searchType.equals("location")){
//	        	Query q = getSession().createQuery("from Job where city= :query");
//	        	q.setString("query", query);
//	        	jobs = q.list();
//	        }else if(searchType.equals("organizationName")){
//	        	Query q = getSession().createQuery("select j from Student s left join s.jobs j where e.organizationName= :query");
//	        	q.setString("query", query);
//	        	jobs = q.list();
//	        }
//			commit();
//			return (Set<Job>) jobs;
//
//		} catch (HibernateException e) {
//			rollback();
//			throw new UserException("Could not get jobs", e);
//		}
//	}

}
