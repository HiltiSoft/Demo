package com.example.demo.controller.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.form.UserListForm;


@Controller
@RequestMapping("/user")
public class UserListController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**Display user list screen */
	@GetMapping("/list")
	public String getUserList(@ModelAttribute UserListForm form, Model model) {
		
		//Convert form to MUser class
		MUser user = modelMapper.map(form,  MUser.class);
		
		//Get user list
		List<MUser> userList = userService.getUsers(user);
		
		//Registered in Model
		System.out.print("getUserList - vor dem Aufruf addAttribute\n");
		model.addAttribute("userList", userList);
		
		System.out.print("getUserList - vor dem return\n");
		//Display user list screen
		return "user/list";
	}
	
	/** User search process */
	@PostMapping("/list")
	public String postUserList(@ModelAttribute UserListForm form, Model model) {
		
		//Convert form to MUser class
		System.out.print("UserListController/POST/beforeConvert\n");
		MUser user = modelMapper.map(form, MUser.class);
		
		//Get user list
		System.out.print("UserListController/POST/beforeUserService: userId=" + user.getUserId() +"\n");
		List<MUser> userList = userService.getUsers(user);
		
		//Registered in Model
		System.out.print("UserListController/POST/beforeRegisterModell\n");
		model.addAttribute("userList", userList);
		
		//Display user list screen
		return "user/list";
	}
	
}
