package com.mrig.rest.webservices.restfulwebservices.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mrig.rest.webservices.restfulwebservices.beans.Todo;
import com.mrig.rest.webservices.restfulwebservices.service.TodoJpaService;
import com.mrig.rest.webservices.restfulwebservices.service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@Autowired
	private TodoJpaService jpaService;
	
	@GetMapping("/users/{username}/todos")
	private List<Todo> getAllTodo(@PathVariable String username){
		return jpaService.getAllByUsernaame(username);
//		return todoService.findAll();
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	private Todo getTodo(@PathVariable String username,@PathVariable Long id){
		return jpaService.getById(id);
//		return todoService.findById(id);
	}
	@DeleteMapping("/users/{username}/todos/{id}")
	private ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Long id){
		jpaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	private ResponseEntity<Todo> updateTodo(@PathVariable String username,
			@PathVariable int id, @RequestBody Todo todo){
		todo.setUsername(username);
		Todo updatedTodo= jpaService.save(todo);
		return new ResponseEntity<Todo>(updatedTodo,HttpStatus.OK);
	}
	
	@PutMapping("/users/{username}/todos/")
	private ResponseEntity<Void> createTodo(@PathVariable String username,
			@PathVariable int id, @RequestBody Todo todo){
		todo.setUsername(username);
		Todo createdTodo= jpaService.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
}
