package com.example.demo.controller.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.form.UserDetailForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserDetailController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;
	
	/** Display user details screen */
	@GetMapping("/detail/{userId:.+}")
	public String getUser(UserDetailForm form, Model model, @PathVariable("userId") String userId) {
		
		// Get user
		MUser user = userService.getUserOne(userId);
		user.setPassword(null);
		
		// Get user
		System.out.print("UserDetailControler/GET/beforeModeMapper\n");
		form = modelMapper.map(user, UserDetailForm.class);
		form.setSalaryList(user.getSalaryList());  /* ModelMapper cannot copy List */
		System.out.print("getSalaryList.size: " + form.getSalaryList().size() + "\n");
		
		//Registered in Model
		System.out.print("UserDetailControler/GET/beforeAddAttribute\n");
		model.addAttribute("userDetailForm", form);
		
		//Display user detail screen
		return "user/detail";
	}

	/** User update process */
	@PostMapping(value = "/detail/detail",params="update")
	public String updateUser(UserDetailForm form, Model model) {

		try {
			//Update user
			System.out.println("Post Detail empfangen: " + form.getUserId() + ";" + form.getPassword() + ";" + form.getUserName() + "\n");
			userService.updateUserOne(form.getUserId(), form.getPassword(), form.getUserName());
		} catch (Exception e) {
			log.error("Error in user update", e);
		}

		//Redirect to user list screen
		return "redirect:/user/list";
	}
	
}
