package com.codeacademy.todo5.vezhba.TodoVezhba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeacademy.todo5.vezhba.TodoVezhba.model.Projects;
import com.codeacademy.todo5.vezhba.TodoVezhba.model.User;
import com.codeacademy.todo5.vezhba.TodoVezhba.repository.ProjectsRepository;


@Service
public class LoginService {

	@Autowired
	private ProjectsRepository projectRepo;
	
	public List<Projects> getProjects(User user){
		return projectRepo.findByUser(user);
	}
}
