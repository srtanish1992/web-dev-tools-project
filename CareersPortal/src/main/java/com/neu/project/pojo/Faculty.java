package com.neu.project.pojo;

import java.io.Serializable;
import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "faculty")
public class Faculty implements Serializable{
	
	private static final long serialVersionUID = -5982965583590944517L;
	@Id
	@GeneratedValue(generator = "idgenerator")
	@GenericGenerator(name = "idgenerator", strategy = "foreign", parameters = {
			@Parameter(value = "user", name = "property") })
	private Long facultyId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "facultyId")
	AllUsers user = new AllUsers();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "faculty")
	private Set<Student> students = new HashSet<Student>(0);
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "faculty")
	private Set<Employer> employers = new HashSet<Employer>(0);
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public AllUsers getUser() {
		return user;
	}
	public void setUser(AllUsers user) {
		this.user = user;
	}
	public Long getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}
	public Set<Employer> getEmployers() {
		return employers;
	}
	public void setEmployers(Set<Employer> employers) {
		this.employers = employers;
	}
	
	

}
