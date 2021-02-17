package com.loan.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.loan.user.exception.UserNotFoundException;
import com.loan.user.service.UserService;

@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RestController
public class UserController {

	@Autowired
	UserService userService;


	@GetMapping("/login/{username}/{password}")
	public boolean validateUser(@PathVariable String username,@PathVariable String password) throws UserNotFoundException{
		return userService.findUser(username,password);
	}
}
