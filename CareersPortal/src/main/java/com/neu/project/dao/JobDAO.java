package com.neu.project.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.neu.project.exception.UserException;
import com.neu.project.pojo.Job;


public class JobDAO extends DAO {

	public JobDAO() {

	}

	public List<Job> getProjects() throws UserException {
		try {
			begin();
			String hql = "FROM Job";
			Query query = getSession().createQuery(hql);
			List<Job> jobs = (List<Job>) query.list();
			commit();
			return jobs;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get jobs", e);
		}
	}

	public Job getJob(Long jobId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Job where jobId= :jobId");
			q.setLong("jobId", jobId);
			Job job = (Job) q.uniqueResult();
			commit();
			return job;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get jobs", e);
		}
	}

	public Job updateJob(Job job) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			getSession().merge(job);
			commit();
			return job;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while updating job jobDAO: " + e.getMessage());
		}
	}

	public Job saveJob(Job job) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			getSession().save(job);
			commit();
			return job;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while updating job jobDAO: " + e.getMessage());
		}
	}

//	public List<Job> getJobsNotApplied(Long studentId) throws UserException{
//		try {
//			begin();
//			
//			Criteria crit = getSession().createCriteria(Job.class);
//			crit.createAlias("students", "studentsAlias");
//			crit.add(Restrictions.or(Restrictions.ne("studentsAlias.studentId", studentId), (Restrictions.isEmpty("studentsAlias")))) ;
//			List<Job> jobs = crit.list();
////			Query q = getSession().createQuery("select j from Job j JOIN j.students s where s.studentId != :studentId");
////			q.setParameter("studentId", studentId);
////			List<Job> jobs = (List<Job>) q.list();
//			commit();
//			return jobs;
//
//		} catch (Exception e) {
//			rollback();
//			throw new UserException("Could not get jobs", e);
//		}
//	}

	public List<Job> getJobsAllJobs() throws UserException{
		try {
			begin();
			Query q = getSession().createQuery("from Job");
			List<Job> jobs = (List<Job>) q.list();
			commit();
			return jobs;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get jobs", e);
		}
	}

	public List<Job> getJobsByQuery(String query, String searchType) throws UserException {
		
		try {
			begin();
			List<Job> jobs = new ArrayList<Job>();
			if(searchType.equals("jobName")){
				Query q = getSession().createQuery("from Job where jobName= :query");
				q.setString("query", query);
				jobs = q.list();
	        }else if(searchType.equals("location")){
	        	Query q = getSession().createQuery("from Job where city= :query");
	        	q.setString("query", query);
	        	jobs = q.list();
	        }else if(searchType.equals("organizationName")){
	        	Query q = getSession().createQuery("select j from Employer e left join e.jobs j where e.organizationName= :query");
	        	q.setString("query", query);
	        	jobs = q.list();
	        }
			commit();
			return jobs;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get jobs", e);
		}
	}
}
