package com.recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recipes.data.UserData;
import com.recipes.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addUser")
	public String addUser(@RequestBody UserData user) {
		boolean status = userService.addUser(user);

		if (status)
			return "user added";

		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/validateUser")
	public String validateUser(@RequestBody UserData user) {
		boolean status = userService.validateUser(user);

		if (status)
			return "success";

		return null;
	}
	
	
}
