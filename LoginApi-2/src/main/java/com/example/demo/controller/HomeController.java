package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	public List<User> getUser() {
		System.out.println("getting users");
		return userService.getUsers();
	}
	
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {
		String name=principal.getName();
		return "{\"name\":\""+ name +"\"}" ;
	}

}