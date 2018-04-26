package com.neu.project.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "email_table")
public class Email implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 429700980890078257L;

	@Id
	@GeneratedValue(generator = "idgenerator")
	@GenericGenerator(name = "idgenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	@Column(name = "emailId", unique = true, nullable = false)
	private long emailId;

	@Column(name = "emailAddress")
	private String emailAddress;

	@OneToOne
	@PrimaryKeyJoinColumn
	private AllUsers user;

	public Email() {
	}

	public Email(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public long getEmailId() {
		return emailId;
	}

	public void setEmailId(long emailId) {
		this.emailId = emailId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public AllUsers getUser() {
		return user;
	}

	public void setUser(AllUsers user) {
		this.user = user;
	}

}
