package com.neu.project.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name="users")
public class AllUsers implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1386261864944023793L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private Long userId;
	@Column(name = "fName", nullable = false)
	private String firstName;
	@Column(name = "lName", nullable = false)
	private String lastName;
	@Column(name = "mName", nullable = true)
	private String middleName;
	@Column(name = "userName", nullable = false, unique = true)
	private String userName;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "role", nullable = false)
	private String role;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "state", nullable = false)
	private String state;
	@Column(name = "phone", nullable = false)
	private String phoneNumber;
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Email email;
	@Transient
	private CommonsMultipartFile photo;
	@Column(name = "filename")
	private String filename;

	public AllUsers(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	public AllUsers() {
	}

	public CommonsMultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
