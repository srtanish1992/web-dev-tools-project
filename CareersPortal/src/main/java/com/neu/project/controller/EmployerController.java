package com.neu.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.dao.EmployerDAO;
import com.neu.project.dao.FacultyDAO;
import com.neu.project.dao.JobDAO;
import com.neu.project.dao.StudentDAO;
import com.neu.project.dao.UserDAO;
import com.neu.project.exception.UserException;
import com.neu.project.pojo.AllUsers;
import com.neu.project.pojo.Email;
import com.neu.project.pojo.Employer;
import com.neu.project.pojo.Faculty;
import com.neu.project.pojo.Job;
import com.neu.project.pojo.Student;
import com.neu.project.validator.EmployerValidator;
import com.neu.project.validator.UserValidator;



/**
 * Handles requests for the application home page.
 */
@Controller
public class EmployerController {

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

	@RequestMapping(value = "/postJob.htm", method = RequestMethod.GET)
	protected String studentJobs(HttpServletRequest request, Model model) throws Exception {
		
		HttpSession session = (HttpSession) request.getSession();
		
//		Job job = new Job();
//		Employer employer = (Employer)request.getSession().getAttribute("employer");
//		job.setEmployer(employer);
		model.addAttribute("job", new Job());
		return "newjob-post";

	}
	
	@RequestMapping(value = "/postJob.htm", method = RequestMethod.POST)
	protected ModelAndView studentJobPost(HttpServletRequest request, @ModelAttribute("job") Job job,
			BindingResult result) throws Exception {
		
		employerValidator.validate(job, result);

		if (result.hasErrors()) {
			return new ModelAndView("newjob-post", "job", job);
		}
		
		Employer employer = (Employer)request.getSession().getAttribute("employer");
		job.setEmployer(employer);
		jobDao.updateJob(job);
		
		return new ModelAndView("success-job-post");
	} 
	
	@RequestMapping(value = "/employerJobs.htm", method = RequestMethod.POST)
	protected ModelAndView employerJobs(HttpServletRequest request) throws Exception {
		
		HttpSession session = (HttpSession) request.getSession();
		
		Employer employer = ((Employer) session.getAttribute("employer"));
		Employer emp1 = employerDao.getEmployerByEmployerId(employer.getEmployerId());
		Set<Job> jobs = emp1.getJobs();
		request.getSession().setAttribute("employer", emp1);
		request.getSession().setAttribute("jobs", jobs);
		return new ModelAndView("employer-homepage");
	}
	
	@RequestMapping(value = "/studentJobs.htm", method = RequestMethod.GET)
	protected ModelAndView studentJobs(HttpServletRequest request) throws Exception {
		
		try {
			String jId = request.getParameter("jId");

			Job job = jobDao.getJob(Long.parseLong(jId));
			Set<Student> approvedStudents = (Set<Student>)job.getApprovedStudents();
//			Set<Student> approvedStudents = new HashSet<Student>();
//			
//			for(Student stu: allstudents) {
//				Set<Job> approvedJobs = stu.getApprovedJobs();
//				if(approvedJobs.contains(job)) {
//					approvedStudents.add(stu);
//				}
//			}

//			if (job != null) {
				request.getSession().setAttribute("students", approvedStudents);
//			}	
			return new ModelAndView("student-job-applied-list");
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while updating ");
		}

		
	}
	
	@RequestMapping(value = "/callStudents.htm", method = RequestMethod.GET)
	protected String callStudents(HttpServletRequest request) throws Exception {

		try {
			HttpSession session = (HttpSession) request.getSession();
			Long studentId = Long.parseLong(request.getParameter("sId"));
			Employer employer = (Employer)request.getSession().getAttribute("employer");
			String emailAddress = employer.getUser().getEmail().getEmailAddress();
			String senderAddress = emailAddress;
			String subject = "Regarding your job Application";
			String message = "You have been selected for the Interview";
			Student s = studentDao.getStudentByStudentId(studentId);
			String recipientAddress = s.getUser().getEmail().getEmailAddress();
			// creates a simple e-mail object
			SimpleMailMessage email = new SimpleMailMessage();
			email.setFrom(senderAddress);
			email.setTo(recipientAddress);
			email.setSubject(subject);
			email.setText(message);
			// sends the e-mail
			mailSender.send(email);
			Set<Student> approvedStudents = (Set<Student>) session.getAttribute("students");
			for(Student stu: approvedStudents) {
				if(stu.getStudentId()==s.getStudentId()) {
					approvedStudents.remove(stu);
				}
			}
			request.getSession().setAttribute("students", approvedStudents);
			return "student-job-applied-list";
		} finally {

		}
		/*
		 * catch (UserException e) { System.out.println("Exception: " +
		 * e.getMessage()); return new ModelAndView("error", "errorMessage",
		 * "error while login"); }
		 */
	}


}
