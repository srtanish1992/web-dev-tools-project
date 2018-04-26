package com.neu.project.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.project.pojo.Employer;



public class EmployerValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {

		return aClass.equals(Employer.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobName", "error.invalid.jobName", "Job Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobDesc", "error.invalid.jobDesc", "Job Description Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "openings", "error.invalid.openings", "No of openings Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.city", "City Required");

		if (errors.hasErrors()) {
			return;
		}
	}
}
