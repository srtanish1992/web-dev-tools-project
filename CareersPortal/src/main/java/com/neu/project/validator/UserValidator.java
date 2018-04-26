
package com.neu.project.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.project.pojo.AllUsers;
import com.neu.project.pojo.Employer;

public class UserValidator implements Validator {

	public boolean supports(Class<?> aClass) {

		return aClass.equals(AllUsers.class);
	}

	public void validate(Object obj, Errors errors) {
		
		Employer emp = (Employer)obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.firstName", "error.invalid.firstName",
				"First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.lastName", "error.invalid.lastName", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.userName", "error.invalid.userName", "Username Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.password", "error.invalid.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.email.emailAddress", "error.invalid.email", "Email Address Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organizationName", "error.invalid.organizationName", "Organization Name Required");
		ValidationUtils.rejectIfEmpty(errors, "industry", "error.invalid.industry", "Industry Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.address", "error.invalid.address", "Address Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.city", "error.invalid.city", "City Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.state", "error.invalid.state", "State Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.phoneNumber", "error.invalid.phoneNumber",
				"Phone Number Required");
		if (errors.hasErrors()) {
			return;
		}
	}

}
