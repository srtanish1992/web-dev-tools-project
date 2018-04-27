package com.neu.project.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "employer")
public class Employer implements Serializable {
	
	private static final long serialVersionUID = -4506135784418849038L;
	
	@Id
	@GeneratedValue(generator = "idgenerator")
	@GenericGenerator(name = "idgenerator", strategy = "foreign", parameters = {
			@Parameter(value = "user", name = "property") })
	private Long employerId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employerId")
	AllUsers user = new AllUsers();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employer")
	private Set<Job> jobs = new HashSet<Job>(0);
	
	@Column(name = "organizationName", nullable = false)
	private String organizationName;
	
	@Column(name = "industry", nullable = false)
	private String industry;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Faculty faculty;
	
	public Long getEmployerId() {
		return employerId;
	}
	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}
	
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public AllUsers getUser() {
		return user;
	}
	public void setUser(AllUsers user) {
		this.user = user;
	}
	public Set<Job> getJobs() {
		return jobs;
	}
	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
}
