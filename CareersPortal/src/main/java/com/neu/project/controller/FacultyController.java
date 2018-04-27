package com.neu.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.neu.project.dao.EmployerDAO;
import com.neu.project.dao.FacultyDAO;
import com.neu.project.dao.JobDAO;
import com.neu.project.dao.StudentDAO;
import com.neu.project.dao.UserDAO;
import com.neu.project.exception.UserException;
import com.neu.project.pojo.AllUsers;
import com.neu.project.pojo.Employer;
import com.neu.project.pojo.Job;
import com.neu.project.pojo.Student;
import com.neu.project.validator.EmployerValidator;

@Controller
public class FacultyController {

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
	
	@Autowired
	 @Qualifier("employerValidator")
	 EmployerValidator employerValidator;
	
	 @InitBinder("employerValidator")
	 private void initEmployeeBinder(WebDataBinder binder) {
	 binder.setValidator(employerValidator);
	 }
	
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "/facultyJobs.htm", method = RequestMethod.GET)
	protected ModelAndView employerJobs(HttpServletRequest request) throws Exception {
			
		HttpSession session = (HttpSession) request.getSession();
		
		String eId = request.getParameter("eId");
		
		Employer employer = employerDao.getEmployerByEmployerId(Long.parseLong(eId));
		Set<Job> jobs = employer.getJobs();
		request.getSession().setAttribute("jobs", jobs);
		return new ModelAndView("faculty-jobs-list");
	}
	
	@RequestMapping(value = "/studentApplications.htm", method = RequestMethod.GET)
	protected ModelAndView studentApplications(HttpServletRequest request) throws Exception {
			
		HttpSession session = (HttpSession) request.getSession();
		
		String jId = request.getParameter("jId");
		
		Job job = jobDao.getJob(Long.parseLong(jId));
		Set<Student> pendingStudents = (Set<Student>)job.getPendingStudents();
		Set<Student> approvedStudents = (Set<Student>)job.getApprovedStudents();
		
		request.getSession().setAttribute("pendingJob", job);
		request.getSession().setAttribute("pendingStudents", pendingStudents);
		request.getSession().setAttribute("approvedStudents", approvedStudents);
		return new ModelAndView("faculty-student-appliedJobs-list");
	}
	
	@RequestMapping(value = "/ApproveStudents.htm", method = RequestMethod.GET)
	protected ModelAndView ApproveStudents(HttpServletRequest request) throws Exception {
			
		HttpSession session = (HttpSession) request.getSession();
		
		String sId = request.getParameter("sId");
		
		Student s1 = studentDao.getStudentByStudentId(Long.parseLong(sId));
		
		Set<Job> approvedJobs = s1.getApprovedJobs();
		Set<Job> pendingJobs = s1.getPendingJobs();
		
		Job pendingSessionJob = (Job) session.getAttribute("pendingJob");
		Job pendingJob = jobDao.getJob(pendingSessionJob.getJobId());
		Job addJob = new Job();
		if(pendingJobs.contains(pendingJob)) {
			pendingJobs.remove(pendingJob);
			approvedJobs.add(pendingJob);
		}
		s1.setApprovedJobs(approvedJobs);
		s1.setPendingJobs(pendingJobs);
		studentDao.updateStudent(s1);
		request.getSession().setAttribute("pendingStudents", pendingJob.getPendingStudents());
		request.getSession().setAttribute("approvedStudents", pendingJob.getApprovedStudents());
		return new ModelAndView("faculty-student-appliedJobs-list");
	}
	
	
	@RequestMapping(value = "/DisapproveStudents.htm", method = RequestMethod.GET)
	protected ModelAndView DisapproveStudents(HttpServletRequest request) throws Exception {
			
		HttpSession session = (HttpSession) request.getSession();
		
		String sId = request.getParameter("sId");
		
		Student s1 = studentDao.getStudentByStudentId(Long.parseLong(sId));
		
		String emailAddress = s1.getFaculty().getUser().getEmail().getEmailAddress();
		String senderAddress = emailAddress;
		String subject = "Regarding your job Application";
		String message = "You have been disapproved for the job";
		String recipientAddress = s1.getUser().getEmail().getEmailAddress();
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(senderAddress);
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		// sends the e-mail
		mailSender.send(email);
		
		Set<Job> approvedJobs = s1.getApprovedJobs();
		Set<Job> pendingJobs = s1.getPendingJobs();
		
		Job pendingSessionJob = (Job) session.getAttribute("pendingJob");
		Job pendingJob = jobDao.getJob(pendingSessionJob.getJobId());
		Job addJob = new Job();
		if(pendingJobs.contains(pendingJob)) {
			pendingJobs.remove(pendingJob);
//			approvedJobs.add(pendingJob);
		}
//		s1.setApprovedJobs(approvedJobs);
		s1.setPendingJobs(pendingJobs);
		studentDao.updateStudent(s1);
		request.getSession().setAttribute("pendingStudents", pendingJob.getPendingStudents());
		request.getSession().setAttribute("approvedStudents", pendingJob.getApprovedStudents());
		return new ModelAndView("faculty-student-appliedJobs-list");
	}
	

}
