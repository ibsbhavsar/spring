package com.main.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.java.dao.UserDAO;
import com.main.java.model.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;

	public List<User> getAllUsers() {
		return this.userDAO.findAll();
	}

	public User addUser(User user) {
		return this.userDAO.save(user);
	}

	public User updateUser(User user) {
		return this.userDAO.save(user);
	}

	public void deleteUserById(int id) {
		this.userDAO.deleteById(id);
	}

	public void deleteAllUsers() {
		this.userDAO.deleteAll();
	}

	public Optional<User> getUserById(int id) {
		return this.userDAO.findById(id);
	}

}
