package com.neu.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
import com.neu.project.validator.UserValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	@Qualifier("userValidator")
	UserValidator userValidator;

	@InitBinder("userValidator")
	private void initUserBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	@Autowired
	ServletContext servletContext;

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

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws UserException
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) throws UserException {

//		 AllUsers user1 = new AllUsers();
//		 Email email1 = new Email();
//		 email1.setEmailAddress("asd@asd.asd");
//		 user1.setAddress("aaa");
//		 user1.setPhoneNumber("1234567890");
//		 user1.setFirstName("Anish");
//		 user1.setLastName("Surti");
//		 user1.setPassword("password1");
//		 user1.setRole("Employer");
//		 user1.setUserName("anish1");
//		 user1.setCity("Boston");
//		 user1.setState("MA");
//		 user1.setEmail(email1);
//		 user1.setMiddleName("Ashok");
//		 user1 = userDao.register(user1);
//		
//		 AllUsers user2 = new AllUsers();
//		 Email email2 = new Email();
//		 email2.setEmailAddress("dsa@asd.asd");
//		 user2.setAddress("aaa");
//		 user2.setPhoneNumber("1234567890");
//		 user2.setFirstName("Sachin");
//		 user2.setLastName("Bharabhe");
//		 user2.setPassword("password2");
//		 user2.setRole("Student");
//		 user2.setUserName("sachin");
//		 user2.setCity("Ney York");
//		 user2.setState("NY");
//		 user2.setEmail(email2);
//		 user2.setMiddleName("Vishnu");
//		 user2 = userDao.register(user2);
//		
//		 AllUsers user3 = new AllUsers();
//		 Email email3 = new Email();
//		 email3.setEmailAddress("eqw@asd.asd");
//		 user3.setAddress("aaa");
//		 user3.setPhoneNumber("1234567890");
//		 user3.setFirstName("Kunal");
//		 user3.setLastName("Amre");
//		 user3.setPassword("password3");
//		 user3.setRole("Faculty");
//		 user3.setUserName("kunal");
//		 user3.setCity("Hoboken");
//		 user3.setState("NJ");
//		 user3.setEmail(email3);
//		 user3.setMiddleName("Prakash");
//		 user3 = userDao.register(user3);
//		 
//		 
//		 
//		 
//		 Faculty faculty = new Faculty();
//		 faculty.setUser(user3);
//		 facultyDao.register(faculty);
//		
//		 Employer emp = new Employer();
//		 emp.setIndustry("Technology");
//		 emp.setOrganizationName("Ahold");
//		 emp.setUser(user1);
//		 emp.setFaculty(faculty);
//		 employerDao.register(emp);
//		
//		 
//		 Student student = new Student();
//		 student.setUser(user2);
//		 student.setFaculty(faculty);
//		 studentDao.register(student);
//		
//		 Set<Job> jobs = new HashSet<Job>();
//		 Job job1 = new Job();
//		 job1.setJobDesc("Heelll");
//		 job1.setJobName("Heelo");
//		 job1.setAvailStatus("Available");
//		 job1.setDeadline("05/20/2018");
//		 job1.setOpenings(1);
//		 job1.setCity("New York");
//		 job1.setState("NY");
//		 job1.setEmployer(emp);
//		 job1 = jobDao.saveJob(job1);
//		 jobs.add(job1);
//		 
//		 Set<Job> jobs4 = new HashSet<Job>();
//		 Job job4 = new Job();
//		 job4.setJobDesc("kladljlskdj");
//		 job4.setJobName("tester");
//		 job4.setAvailStatus("Available");
//		 job4.setDeadline("05/20/2018");
//		 job4.setOpenings(1);
//		 job4.setCity("New York");
//		 job4.setState("NY");
//		 job4.setEmployer(emp);
//		 job4 = jobDao.saveJob(job4);
//		 jobs4.add(job4);
//		 
//		 student.setPendingJobs(jobs);
//		 student.setApprovedJobs(jobs4);
//		 studentDao.updateStudent(student);
//		
//		 Job job2 = new Job();
//		 job2.setJobDesc("byee");
//		 job2.setJobName("Bye");
//		 job2.setAvailStatus("Available");
//		 job2.setDeadline("06/20/2018");
//		 job2.setOpenings(2);
//		 job2.setCity("Boston");
//		 job2.setState("MA");
//		 job2.setEmployer(emp);
//		 job2 = jobDao.saveJob(job2);
//		
//		 Job job3 = new Job();
//		 job3.setJobDesc("Cyaa");
//		 job3.setJobName("cyyyy");
//		 job3.setAvailStatus("Available");
//		 job3.setDeadline("07/20/2018");
//		 job3.setOpenings(3);
//		 job3.setCity("Cali");
//		 job3.setState("CA");
//		 job3.setEmployer(emp);
//		 job3 = jobDao.saveJob(job3);

		AllUsers user = (AllUsers) request.getSession().getAttribute("user");
		if (user == null) {
			request.getSession().invalidate();
		}

		/*
		 * Project proj = projectDao.getProject("rohan"); Volunteer vol =
		 * volunteerDao.getVolunteerByVolunteerId(5L);
		 * vol.setIsAssignedToAProject("Yes"); vol.setIsAvailable("No");
		 * vol.setProject(proj); volunteerDao.updateVolunteer(vol);
		 */
		return "home";

	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	protected ModelAndView loginUser(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		try {

			System.out.print("loginUser");
			AllUsers u = userDao.get(request.getParameter("username"), request.getParameter("password"));

			if (u == null) {
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return new ModelAndView("error");
			}

			session.setAttribute("user", u);
			if (u.getRole().equalsIgnoreCase("Employer")) {

				Employer employer = employerDao.getEmployerByUserId(u);
				Set<Job> jobs = employer.getJobs();
				request.getSession().setAttribute("employer", employer);
				request.getSession().setAttribute("jobs", jobs);
				return new ModelAndView("employer-homepage");
			} else if (u.getRole().equalsIgnoreCase("Student")) {
				Student student = studentDao.getStudentByStudentId(u.getUserId());
				Set<Job> approvedJobs = student.getApprovedJobs();
				Set<Job> pendingJobs = student.getPendingJobs();
				List<Job> allJobs = jobDao.getJobsAllJobs();
				Set<Job> notAppliedJobs = new HashSet<Job>();
				
				for(Job j1: allJobs) {
					if(!approvedJobs.contains(j1) && !pendingJobs.contains(j1)) {
						notAppliedJobs.add(j1);
					}
				}
				
				request.getSession().setAttribute("notAppliedJobs", notAppliedJobs);
				request.getSession().setAttribute("aJobs", approvedJobs);
				request.getSession().setAttribute("pJobs", pendingJobs);
				request.getSession().setAttribute("student", student);
				return new ModelAndView("student-homepage");
			} else if (u.getRole().equalsIgnoreCase("Faculty")) {
				Faculty faculty = facultyDao.getfacultyByUserId(u);
				request.getSession().setAttribute("faculty", faculty);
				Set<Employer> employers = faculty.getEmployers();
				request.getSession().setAttribute("employers", employers);
				return new ModelAndView("faculty-homepage");
			}

			return new ModelAndView("home");

		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}

	}

	@RequestMapping(value = "/register.htm", method = RequestMethod.GET)
	protected ModelAndView registerSFUser() throws Exception {
		System.out.print("registerUser");
		Employer employer = new Employer();
		AllUsers users = new AllUsers();
		employer.setUser(users);
		return new ModelAndView("user-register", "employer", employer);

	}

	@RequestMapping(value = "/register.htm", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request, @ModelAttribute("employer") Employer employer,
			BindingResult result) throws Exception {
		
		HttpSession session = (HttpSession) request.getSession();

		userValidator.validate(employer, result);

		if (result.hasErrors()) {
			return new ModelAndView("user-register", "employer", employer);
		}
		try {

			System.out.print("registerNewUser");
			CommonsMultipartFile photoInMemory = employer.getUser().getPhoto();
			String fileName = photoInMemory.getOriginalFilename();
			String baseName = "D:/WEB_DEV_TOOLS/Project/photos/";
			File userFile = new File(baseName + employer.getUser().getEmail().getEmailId());
			String currentTime = String.valueOf(System.currentTimeMillis());
			if (!userFile.exists()) {
				if (userFile.mkdir()) {
					File eventFile = new File(userFile + "/" + currentTime);
					eventFile.mkdir();
					employer.getUser().setFilename(eventFile.getPath());
				}
			} else {
				File eventFile = new File(userFile + "/" + currentTime);
				if (!eventFile.exists()) {
					if (eventFile.mkdir()) {
						employer.getUser().setFilename(eventFile.getPath());
					}
				}
			}
			File localFile = new File(baseName + employer.getUser().getEmail().getEmailId() + "/" + currentTime + "/",
					fileName);
			photoInMemory.transferTo(localFile);
			employer.getUser().setFilename(localFile.getPath());
			employer.getUser().setRole("Employer");
			AllUsers user = userDao.register(employer.getUser());
			employer.setUser(user);
			Faculty faculty = facultyDao.getfaculty();
			employer.setFaculty(faculty);
			employerDao.register(employer);
			// request.getSession().setAttribute("user", u);
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		} catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("*** IOException: " + e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("home");
	}

}
