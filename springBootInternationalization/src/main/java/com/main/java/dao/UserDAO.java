package com.main.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.java.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

}
