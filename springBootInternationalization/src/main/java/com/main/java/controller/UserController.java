package com.main.java.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.java.model.User;
import com.main.java.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	MessageSource messageSource;

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@PostMapping("/addUser")
	public User addUser(User user) {
		return this.userService.addUser(user);
	}

	@PostMapping("/updateUser")
	public User updateUser(User user) {
		return this.userService.updateUser(user);
	}

	@GetMapping("/getUser/{id}")
	public Optional<User> getUserById(@PathVariable int id) {
		return this.userService.getUserById(id);
	}

	@GetMapping("/deleteUser/{id}")
	public void deleteUserById(@PathVariable int id) {
		this.userService.deleteUserById(id);
	}

	@GetMapping("/deleteAllUsers")
	public void deleteAllUsers() {
		this.userService.deleteAllUsers();
	}

	@GetMapping("/get-greetings")
	public String greeting() {

		return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
	}
	
	@GetMapping("/get-greetings-name")
	public String greetingWithName() {
		String params[] = new String[] { "Bhavin", "Today" };
		return messageSource.getMessage("good.morning.name", params, LocaleContextHolder.getLocale());
	}
}
