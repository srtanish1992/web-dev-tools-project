package com.neu.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
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
import com.neu.project.filter.XSSClean;
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

//		 // Students
//		
//		 AllUsers user1 = new AllUsers();
//		 Email email1 = new Email();
//		 email1.setEmailAddress("anish@asd.asd");
//		 user1.setAddress("Dahanu");
//		 user1.setPhoneNumber("8544567890");
//		 user1.setFirstName("Anish");
//		 user1.setLastName("Surti");
//		 user1.setPassword("password1");
//		 user1.setRole("Student");
//		 user1.setUserName("anish");
//		 user1.setCity("Mumbai");
//		 user1.setState("Maharashtra");
//		 user1.setEmail(email1);
//		 user1.setMiddleName("Ashok");
//		 user1 = userDao.register(user1);
//		
//		 AllUsers user2 = new AllUsers();
//		 Email email2 = new Email();
//		 email2.setEmailAddress("sachin@asd.asd");
//		 user2.setAddress("Vangaon");
//		 user2.setPhoneNumber("0214567890");
//		 user2.setFirstName("Sachin");
//		 user2.setLastName("Bharabhe");
//		 user2.setPassword("password2");
//		 user2.setRole("Student");
//		 user2.setUserName("sachin");
//		 user2.setCity("Nagpur");
//		 user2.setState("Maharashtra");
//		 user2.setEmail(email2);
//		 user2.setMiddleName("Vishnu");
//		 user2 = userDao.register(user2);
//		
//		 AllUsers user3 = new AllUsers();
//		 Email email3 = new Email();
//		 email3.setEmailAddress("kunal@asd.asd");
//		 user3.setAddress("New Orleans");
//		 user3.setPhoneNumber("1234567458");
//		 user3.setFirstName("Kunal");
//		 user3.setLastName("Amre");
//		 user3.setPassword("password3");
//		 user3.setRole("Student");
//		 user3.setUserName("kunal");
//		 user3.setCity("Orleans");
//		 user3.setState("NO");
//		 user3.setEmail(email3);
//		 user3.setMiddleName("Prakash");
//		 user3 = userDao.register(user3);
		 
//		 // Faculty
		 
//		 AllUsers user4 = new AllUsers();
//		 Email email4 = new Email();
//		 email4.setEmailAddress("rohan@asd.asd");
//		 user4.setAddress("Cityview");
//		 user4.setPhoneNumber("1238717890");
//		 user4.setFirstName("Rohan");
//		 user4.setLastName("Patil");
//		 user4.setPassword("password4");
//		 user4.setRole("Faculty");
//		 user4.setUserName("rohan");
//		 user4.setCity("Boston");
//		 user4.setState("MA");
//		 user4.setEmail(email4);
//		 user4.setMiddleName("Patil");
//		 user4 = userDao.register(user4);
//		 
//		 AllUsers user5 = new AllUsers();
//		 Email email5 = new Email();
//		 email5.setEmailAddress("akhil@asd.asd");
//		 user5.setAddress("Waltham");
//		 user5.setPhoneNumber("8574567890");
//		 user5.setFirstName("Akhil");
//		 user5.setLastName("Rane");
//		 user5.setPassword("password5");
//		 user5.setRole("Faculty");
//		 user5.setUserName("akhil");
//		 user5.setCity("Boston");
//		 user5.setState("MA");
//		 user5.setEmail(email5);
//		 user5.setMiddleName("Rane");
//		 user5 = userDao.register(user5);
//		 
//		 AllUsers user6 = new AllUsers();
//		 Email email6 = new Email();
//		 email6.setEmailAddress("parth@asd.asd");
//		 user6.setAddress("Gujarat");
//		 user6.setPhoneNumber("8570007890");
//		 user6.setFirstName("Parth");
//		 user6.setLastName("Tandel");
//		 user6.setPassword("password6");
//		 user6.setRole("Faculty");
//		 user6.setUserName("parth");
//		 user6.setCity("Ahmedabad");
//		 user6.setState("GJ");
//		 user6.setEmail(email6);
//		 user6.setMiddleName("Tandel");
//		 user6 = userDao.register(user6);
		 
//		 // Employers
//		 
//		 AllUsers user7 = new AllUsers();
//		 Email email7 = new Email();
//		 email7.setEmailAddress("ketan@asd.asd");
//		 user7.setAddress("Framingham");
//		 user7.setFilename("D:\\WEB_DEV_TOOLS\\Project\\image7.jpg");
//		 user7.setPhoneNumber("8578967890");
//		 user7.setFirstName("Ketan");
//		 user7.setLastName("Hal");
//		 user7.setPassword("password7");
//		 user7.setRole("Employer");
//		 user7.setUserName("ketan");
//		 user7.setCity("Boston");
//		 user7.setState("MA");
//		 user7.setEmail(email7);
//		 user7.setMiddleName("Hal");
//		 user7 = userDao.register(user7);
//		 
//		 AllUsers user8 = new AllUsers();
//		 Email email8 = new Email();
//		 email8.setEmailAddress("ankit@asd.asd");
//		 user8.setAddress("Columbus");
//		 user8.setFilename("D:\\WEB_DEV_TOOLS\\Project\\image8.jpg");
//		 user8.setPhoneNumber("8574652890");
//		 user8.setFirstName("Ankit");
//		 user8.setLastName("Wagh");
//		 user8.setPassword("password8");
//		 user8.setRole("Employer");
//		 user8.setUserName("ankit");
//		 user8.setCity("Atlanta");
//		 user8.setState("CT");
//		 user8.setEmail(email8);
//		 user8.setMiddleName("Wagh");
//		 user8 = userDao.register(user8);
//		 
//		 AllUsers user9 = new AllUsers();
//		 Email email9 = new Email();
//		 email9.setEmailAddress("akshay@asd.asd");
//		 user9.setAddress("Palghar");
//		 user9.setFilename("D:\\WEB_DEV_TOOLS\\Project\\image9.jpg");
//		 user9.setPhoneNumber("8577427890");
//		 user9.setFirstName("Akshay");
//		 user9.setLastName("Gughe");
//		 user9.setPassword("password9");
//		 user9.setRole("Employer");
//		 user9.setUserName("akshay");
//		 user9.setCity("Palghar");
//		 user9.setState("Maharashtra");
//		 user9.setEmail(email9);
//		 user9.setMiddleName("Gughe");
//		 user9 = userDao.register(user9);
//		 
//		 
//		 
//		 
//		 Faculty faculty1 = new Faculty();
//		 faculty1.setUser(user4);
//		 facultyDao.register(faculty1);
//		 
//		 Faculty faculty2 = new Faculty();
//		 faculty2.setUser(user5);
//		 facultyDao.register(faculty2);
//		 
//		 Faculty faculty3 = new Faculty();
//		 faculty3.setUser(user6);
//		 facultyDao.register(faculty3);
//		
//		 Employer emp1 = new Employer();
//		 emp1.setIndustry("Technology");
//		 emp1.setOrganizationName("Amadeus");
//		 emp1.setUser(user7);
//		 emp1.setFaculty(faculty1);
//		 employerDao.register(emp1);
//		 
//		 Employer emp2 = new Employer();
//		 emp2.setIndustry("Technology");
//		 emp2.setOrganizationName("Ahold Delhaize");
//		 emp2.setUser(user8);
//		 emp2.setFaculty(faculty2);
//		 employerDao.register(emp2);
//		 
//		 Employer emp3 = new Employer();
//		 emp3.setIndustry("Technology");
//		 emp3.setOrganizationName("Isobar");
//		 emp3.setUser(user9);
//		 emp3.setFaculty(faculty3);
//		 employerDao.register(emp3);
//		
//		 
//		 Student student1 = new Student();
//		 student1.setUser(user1);
//		 student1.setFaculty(faculty1);
//		 studentDao.register(student1);
//		 
//		 Student student2 = new Student();
//		 student2.setUser(user2);
//		 student2.setFaculty(faculty2);
//		 studentDao.register(student2);
//		 
//		 Student student3 = new Student();
//		 student3.setUser(user3);
//		 student3.setFaculty(faculty3);
//		 studentDao.register(student3);
//		
//		 Set<Job> jobs = new HashSet<Job>();
//		 Job job1 = new Job();
//		 job1.setJobDesc("Create java backend services.");
//		 job1.setJobName("Java Developer");
//		 job1.setAvailStatus("Available");
//		 job1.setDeadline("05/20/2018");
//		 job1.setOpenings(1);
//		 job1.setCity("New York");
//		 job1.setState("NY");
//		 job1.setEmployer(emp1);
//		 job1 = jobDao.saveJob(job1);
//		 jobs.add(job1);
//		 
//		 Set<Job> jobs4 = new HashSet<Job>();
//		 Job job4 = new Job();
//		 job4.setJobDesc("Create CRUD based websites.");
//		 job4.setJobName("Front End Developer");
//		 job4.setAvailStatus("Available");
//		 job4.setDeadline("08/1/2018");
//		 job4.setOpenings(2);
//		 job4.setCity("Boston");
//		 job4.setState("MA");
//		 job4.setEmployer(emp2);
//		 job4 = jobDao.saveJob(job4);
//		 jobs4.add(job4);
//		 
//		 student1.setPendingJobs(jobs);
//		 student1.setApprovedJobs(jobs4);
//		 studentDao.updateStudent(student1);
//		
//		 Job job2 = new Job();
//		 job2.setJobDesc("Create algorithms.");
//		 job2.setJobName("Software Engineer");
//		 job2.setAvailStatus("Available");
//		 job2.setDeadline("06/05/2018");
//		 job2.setOpenings(5);
//		 job2.setCity("Detroit");
//		 job2.setState("Michigan");
//		 job2.setEmployer(emp2);
//		 job2 = jobDao.saveJob(job2);
//		
//		 Job job3 = new Job();
//		 job3.setJobDesc("Create web applications.");
//		 job3.setJobName("Application Developer");
//		 job3.setAvailStatus("Available");
//		 job3.setDeadline("07/20/2018");
//		 job3.setOpenings(3);
//		 job3.setCity("California");
//		 job3.setState("CA");
//		 job3.setEmployer(emp3);
//		 job3 = jobDao.saveJob(job3);

		AllUsers user = (AllUsers) request.getSession().getAttribute("user");
		if (user == null) {
			request.getSession().invalidate();
		}

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

			XSSClean xss = new XSSClean();
			employer.getUser().setFirstName(xss.cleanXSS(employer.getUser().getFirstName()));
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
//			Faculty faculty = facultyDao.getfaculty();
			List<Faculty> faculties = facultyDao.getfaculty();
			Random rand = new Random();
			Faculty faculty = faculties.get(rand.nextInt(faculties.size()));
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
