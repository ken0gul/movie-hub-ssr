package com.coderscampus.ogulcanfinal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderscampus.ogulcanfinal.domain.User;
import com.coderscampus.ogulcanfinal.service.UserService;

@Controller
@RequestMapping("/users")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String getRegistrationPage(ModelMap model) {
		
		model.put("user", new User());
		return "registration";
	}
	
	@PostMapping("/register")
	public String createUser(User user) {
		userService.save(user);
		
		return "redirect:/movies";
	}
	
}