package com.neu.project.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.dao.EmployerDAO;
import com.neu.project.dao.FacultyDAO;
import com.neu.project.dao.JobDAO;
import com.neu.project.dao.StudentDAO;
import com.neu.project.dao.UserDAO;
import com.neu.project.pojo.Job;
import com.neu.project.pojo.Student;

/**
 * Handles requests for the application home page.
 */
@Controller
public class StudentController {

	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;

	@Autowired
	@Qualifier("jobDao")
	JobDAO jobDao;

	@Autowired
	@Qualifier("employerDao")
	EmployerDAO employerDao;

	@Autowired
	@Qualifier("studentDao")
	StudentDAO studentDao;

	@Autowired
	@Qualifier("facultyDao")
	FacultyDAO facultyDao;

	@RequestMapping(value = "/jobView.htm", method = RequestMethod.GET)
	protected String jobsList(HttpServletRequest request, Model model) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		String jId = request.getParameter("jId");
		Job job = jobDao.getJob(Long.parseLong(jId));
		request.getSession().setAttribute("job", job);
		return "job-details";

	}

	@RequestMapping(value = "/applyJobs.htm", method = RequestMethod.GET)
	protected String jobApplied(HttpServletRequest request, Model model) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		String jId = request.getParameter("jId");
		Job job = jobDao.getJob(Long.parseLong(jId));
		Student student = ((Student) session.getAttribute("student"));
		Student s1 = studentDao.getStudentByStudentId(student.getStudentId());
		Set<Job> jobs = s1.getPendingJobs();
		jobs.add(job);
		s1.setPendingJobs(jobs);
		studentDao.updateStudent(s1);
		session.setAttribute("student", s1);
		return "student-job-success";

	}

	@RequestMapping(value = "/goBackJobsList.htm", method = RequestMethod.POST)
	protected ModelAndView goBackJobsList(HttpServletRequest request, Model model) throws Exception {

		HttpSession session = (HttpSession) request.getSession();
		Student student1 = ((Student) session.getAttribute("student"));
		Student student = studentDao.getStudentByStudentId(student1.getStudentId());
		Set<Job> approvedJobs = student.getApprovedJobs();
		Set<Job> pendingJobs = student.getPendingJobs();
		List<Job> allJobs = jobDao.getJobsAllJobs();
		Set<Job> notAppliedJobs = new HashSet<Job>();
		for (Job j1 : allJobs) {
			if (!approvedJobs.contains(j1) && !pendingJobs.contains(j1)) {
				notAppliedJobs.add(j1);
			}
		}
		request.getSession().setAttribute("notAppliedJobs", notAppliedJobs);
		request.getSession().setAttribute("aJobs", approvedJobs);
		request.getSession().setAttribute("pJobs", pendingJobs);
		request.getSession().setAttribute("student", student);
		return new ModelAndView("student-homepage");
	}

	@RequestMapping(value = "/cancelApplication.htm", method = RequestMethod.GET)
	protected String cancelApplication(HttpServletRequest request, Model model) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		String jId = request.getParameter("jobId");
		Job job = jobDao.getJob(Long.parseLong(jId));
		Student student = ((Student) session.getAttribute("student"));
		Student s1 = studentDao.getStudentByStudentId(student.getStudentId());
		Set<Job> jobs = s1.getPendingJobs();
		jobs.remove(job);
		s1.setPendingJobs(jobs);
		studentDao.updateStudent(s1);
		session.setAttribute("student", s1);
		session.setAttribute("removedJob", job);
		return "student-cancel-application-success";

	}

	@RequestMapping(value = "/search.htm", method = RequestMethod.GET)
	protected String search(HttpServletRequest request, Model model) throws Exception {

		HttpSession session = (HttpSession) request.getSession();
		String keywordVal = request.getParameter("keywordval");
		String searchType = request.getParameter("radmovieinfo");
		String buttonType = request.getParameter("button");
		Student student1 = ((Student) session.getAttribute("student"));
		Student student = studentDao.getStudentByStudentId(student1.getStudentId());
		Set<Job> approvedJobs = student.getApprovedJobs();
		Set<Job> pendingJobs = student.getPendingJobs();
		List<Job> allJobs = jobDao.getJobsAllJobs();
		Set<Job> notAppliedJobs = new HashSet<Job>();
		for (Job j1 : allJobs) {
			if (!approvedJobs.contains(j1) && !pendingJobs.contains(j1)) {
				notAppliedJobs.add(j1);
			}
		}
		Set<Job> newJobs = new HashSet<Job>();
		if (buttonType.equalsIgnoreCase("Search")) {
			if (searchType.equalsIgnoreCase("jobName")) {
				for (Job job : notAppliedJobs)
					if (keywordVal.equalsIgnoreCase(job.getJobName()))
						newJobs.add(job);
			} else if (searchType.equalsIgnoreCase("location")) {
				for (Job job : notAppliedJobs)
					if (keywordVal.equalsIgnoreCase(job.getCity()))
						newJobs.add(job);
			} else if (searchType.equalsIgnoreCase("organizationName")) {
				for (Job job : notAppliedJobs)
					if (keywordVal.equalsIgnoreCase(job.getEmployer().getOrganizationName()))
						newJobs.add(job);
			}
		} else if (buttonType.equalsIgnoreCase("Reset")) {
			newJobs = notAppliedJobs;
		}
		request.getSession().setAttribute("notAppliedJobs", newJobs);
		return "student-homepage";

	}

}
