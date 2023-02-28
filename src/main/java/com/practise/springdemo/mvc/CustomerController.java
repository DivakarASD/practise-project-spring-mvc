package com.practise.springdemo.mvc;

import jakarta.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;

//import javax.naming.Binding;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";				
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "customer-form";
		}
		else {
//			System.out.println("no errors");
			return "customer-confirmation";
		}	
	}
	
	
	
	
	
	
	
	

}
