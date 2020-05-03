package com.mrig.rest.webservices.restfulwebservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mrig.rest.webservices.restfulwebservices.beans.Todo;

@Service
public class TodoService {

	private static List<Todo> todos= new ArrayList<>();
	private static Long idCounter=0l;
	
	static {
		todos.add(new Todo(++idCounter,"mrig.b","To learn react", new Date(),false ));
		todos.add(new Todo(++idCounter,"mrig.b","To learn python", new Date(),false ));
		todos.add(new Todo(++idCounter,"mrig.b","To learn ML", new Date(),false ));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo deleteById(Long id) {
		Todo todo=findById(id);
		if(todo==null) return null;
		if(todos.remove(todo)) return todo;
		return null;
	}

	public Todo findById(Long id) {
		for(Todo todo:todos) {
			if(todo.getId()==id)
				return todo;
		}
		return null;
	}
}
