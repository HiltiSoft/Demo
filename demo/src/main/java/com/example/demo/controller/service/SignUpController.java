package com.example.demo.controller.service;
import java.util.Map;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.application.service.UserApplicationService;
import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.form.GroupOrder;
import com.example.demo.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignUpController {
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/** Display the user signup screen */
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
		//Get gender
		Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
		model.addAttribute("genderMap",genderMap);
		//Transition to user signup screen
		return "user/signup";
		
	}

	@PostMapping("/signup")
	public String postSignup(Model model, Locale locale,
		@ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult) {
		
		//Input check result
		if (bindingResult.hasErrors()) {
			//NG: Return to the user signup screen
			return getSignup(model, locale, form);
		}
		
		log.info(form.toString());
		
		//Convert form to MUser class
		MUser user = modelMapper.map(form, MUser.class);
		
		// user signup
		userService.signup(user);
		
		//Redirect to login screen
		return "redirect:/login";
	}
}
