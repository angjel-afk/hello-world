package com.codeacademy.todo5.vezhba.TodoVezhba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeacademy.todo5.vezhba.TodoVezhba.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
