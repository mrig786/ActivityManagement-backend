package com.mrig.rest.webservices.restfulwebservices.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrig.rest.webservices.restfulwebservices.beans.Todo;

public interface TodoJpaRepository extends JpaRepository<Todo, Long> {
	
	List<Todo> findByUsername(String username);

}
