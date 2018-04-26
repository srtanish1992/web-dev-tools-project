package com.neu.project.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = -5982965583590944517L;
	@Id
	@GeneratedValue(generator = "idgenerator")
	@GenericGenerator(name = "idgenerator", strategy = "foreign", parameters = {
			@Parameter(value = "user", name = "property") })
	private Long studentId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId")
	AllUsers user = new AllUsers();

	@ManyToOne(cascade = CascadeType.ALL)
	private Faculty faculty;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "student_aprrovedJob", joinColumns = @JoinColumn(name = "studentId"), inverseJoinColumns = @JoinColumn(name = "jobId"))
	private Set<Job> approvedJobs = new HashSet<Job>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "student_pendingJob", joinColumns = @JoinColumn(name = "studentId"), inverseJoinColumns = @JoinColumn(name = "jobId"))
	private Set<Job> pendingJobs = new HashSet<Job>();

	// @ManyToOne(cascade = CascadeType.ALL)
	// private Job job;

	public AllUsers getUser() {
		return user;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Set<Job> getApprovedJobs() {
		return approvedJobs;
	}

	public void setApprovedJobs(Set<Job> approvedJobs) {
		this.approvedJobs = approvedJobs;
	}

	public Set<Job> getPendingJobs() {
		return pendingJobs;
	}

	public void setPendingJobs(Set<Job> pendingJobs) {
		this.pendingJobs = pendingJobs;
	}

	public void setUser(AllUsers user) {
		this.user = user;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

}
