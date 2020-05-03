package com.mrig.rest.webservices.restfulwebservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrig.rest.webservices.restfulwebservices.beans.Todo;

@Service
public class TodoJpaService {
	
	@Autowired
	private TodoJpaRepository todoJpaRepository;

	public List<Todo> getAllByUsernaame(String username) {
		// TODO Auto-generated method stub
		return todoJpaRepository.findByUsername(username);
	}
	
	public Todo getById(Long id) {
		return todoJpaRepository.findById(id).get();
	}
	
	public void deleteById(Long id)
	{
		todoJpaRepository.deleteById(id);
	}
	public Todo save(Todo todo) {
		return todoJpaRepository.save(todo);
	}
	

}
