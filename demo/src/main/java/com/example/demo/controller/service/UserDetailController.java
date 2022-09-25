package com.example.demo.controller.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.form.UserDetailForm;

@Controller
@RequestMapping("/user")
public class UserDetailController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;
	
	/** Display user datails screen */
	@GetMapping("/detail/{userId:.+}")
	public String getUser(UserDetailForm form, org.springframework.ui.Model model, @PathVariable("userId") String userId) {
		
		// Get user
		MUser user = userService.getUserOne(userId);
		user.setPassword(null);
		
		// Get user
		form = modelMapper.map(user, UserDetailForm.class);
		
		//Registered in Model
		model.addAttribute("userDetailForm", form);
		
		//Display user detail screen
		return "user/detail";
	}

}
