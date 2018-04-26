package com.neu.project.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "job")
public class Job implements Serializable {

	private static final long serialVersionUID = -8840859690578385365L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "jobId")
	private Long jobId;

	@ManyToOne(cascade = CascadeType.ALL)
	private Employer employer;

	@ManyToMany(mappedBy = "approvedJobs")
	private Set<Student> approvedStudents = new HashSet<Student>(0);
	
	@ManyToMany(mappedBy = "pendingJobs")
	private Set<Student> pendingStudents = new HashSet<Student>(0);

	@Column(name = "jobName", nullable = false, unique = true)
	private String jobName;

	@Column(name = "jobDesc")
	private String jobDesc;

	@Column(name = "openings", nullable = false)
	private int openings;

	@Column(name = "availStatus", nullable = false)
	private String availStatus;

	@Column(name = "deadline")
	@DateTimeFormat(pattern = "yyyy/mm/dd")
	private String deadline;

	@Column(name = "state", nullable = false)
	private String state;

	@Column(name = "city", nullable = false)
	private String city;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getOpenings() {
		return openings;
	}

	public void setOpenings(int openings) {
		this.openings = openings;
	}

	public String getAvailStatus() {
		return availStatus;
	}

	public void setAvailStatus(String availStatus) {
		this.availStatus = availStatus;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Set<Student> getApprovedStudents() {
		return approvedStudents;
	}

	public void setApprovedStudents(Set<Student> approvedStudents) {
		this.approvedStudents = approvedStudents;
	}

	public Set<Student> getPendingStudents() {
		return pendingStudents;
	}

	public void setPendingStudents(Set<Student> pendingStudents) {
		this.pendingStudents = pendingStudents;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

}
