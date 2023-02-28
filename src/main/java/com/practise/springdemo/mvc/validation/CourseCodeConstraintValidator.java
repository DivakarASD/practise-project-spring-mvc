package com.practise.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator 
	implements ConstraintValidator<CourseCode, String> {

	private String[] coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, 
						ConstraintValidatorContext theConstraintValidatorContext) {

		boolean result = false;
		
		if (theCode != null) {
			for (String tempPrefix : coursePrefix) {
				result = theCode.startsWith(tempPrefix);

				if (result) {
					break;
				}
			}
		}
		else {
			result = true;
		}
		
		return result;
	}
}