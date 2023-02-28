package com.practise.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	public String[] value() default "ABC";
	
	// define default error message
	public String message() default "must start with ABC";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};
}