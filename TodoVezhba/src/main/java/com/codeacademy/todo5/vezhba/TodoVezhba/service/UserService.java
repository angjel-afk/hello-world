package com.codeacademy.todo5.vezhba.TodoVezhba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeacademy.todo5.vezhba.TodoVezhba.model.User;
import com.codeacademy.todo5.vezhba.TodoVezhba.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
}
