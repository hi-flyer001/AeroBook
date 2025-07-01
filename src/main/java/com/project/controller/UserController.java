package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.User;
import com.project.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	
	
	
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		service.register(user);
		return "User added Success";
	}
	@PostMapping("/verified")
	public String verify(@RequestBody User u, @RequestParam int otp) {
		return service.verify(u, otp);
		
		
	}
}
