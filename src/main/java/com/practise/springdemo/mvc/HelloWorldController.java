package com.practise.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@Controller

public class HelloWorldController {
	
	@RequestMapping("/")
	public String home() {
		return "main-menu";
	}
	@RequestMapping("/showForm")
	public String showForm() {
		System.out.println("Request....");
		return "studentForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		System.out.println("Response.....");
		return "helloWorld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(
			@RequestParam("studentName") String name, 
			Model model) {
		name = name.toUpperCase();
		
		String resultString = "Hey my friend " + name;
		
		model.addAttribute("message", resultString);
		System.out.println("Response 2...");
		return "helloWorld";
	}
	
//	public String letsShoutDude(HttpServletRequest request, Model model) {
//		String name = request.getParameter("studentName");
//		name = name.toUpperCase();
//		
//		String resultString = "Yo! " + name;
//		
//		model.addAttribute("message", resultString);
//		System.out.println("Response 2...");
//		return "helloWorld";
//	}
	

}
