package com.example.demo.controller.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	/** Display login screen */
	public String getLogin() {
		return "login/login";
	}
	
	/** Redirect to user list screen */
	@PostMapping("login")
	public String postLogin() {
		return "redirect:/user/list";
	}
	
}
