package com.codeacademy.todo5.vezhba.TodoVezhba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeacademy.todo5.vezhba.TodoVezhba.model.Projects;
import com.codeacademy.todo5.vezhba.TodoVezhba.model.User;

public interface ProjectsRepository extends JpaRepository<Projects, Long>{

	List<Projects> findByUser(User user);

}
