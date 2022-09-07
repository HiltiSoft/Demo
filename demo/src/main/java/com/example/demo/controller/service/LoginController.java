package com.example.demo.controller.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	/** Display login screen */
	public String getLogin() {
		return "login/login";
	}
	
}
