package com.practise.springdemo.mvc;

//import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		Student student = new Student();
		
		System.out.print(student);
		model.addAttribute("student", student);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		System.out.println("Student name: " + student.getFirstName() + " " + student.getLastName());
		System.out.println(student.getCountry());	
		return "student-confirmation";
	}
	
}
