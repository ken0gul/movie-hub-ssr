package com.coderscampus.ogulcanfinal.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderscampus.ogulcanfinal.domain.User;
import com.coderscampus.ogulcanfinal.service.UserService;

@Controller
@RequestMapping("/users")
public class RegistrationController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String getRegistrationPage(ModelMap model) {
		List<User> users = userService.findAll();

		model.put("user", new User());

		return "registration";
	}

	@PostMapping("/register")
	public String createUser(@ModelAttribute User user, Model model) {
		
		boolean isUsernameExists = userService.usernameExists(user.getUsername());
		
		if(isUsernameExists) {
			model.addAttribute("errorMessage","Username already exists");
			return "registration";
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);

		return "redirect:/login";
	}

}
