package com.codeacademy.todo5.vezhba.TodoVezhba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codeacademy.todo5.vezhba.TodoVezhba.model.User;
import com.codeacademy.todo5.vezhba.TodoVezhba.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String getRegisterForm() {
		return "register";
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String postRegisterForm(@RequestBody String body, User user, Model model) {
		user = service.saveUser(user);
		model.addAttribute("username", user.getUsername());
		model.addAttribute("user", user);
		return "welcome";
	}
	
	
}
