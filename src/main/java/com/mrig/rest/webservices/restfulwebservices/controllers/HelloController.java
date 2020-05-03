package com.mrig.rest.webservices.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mrig.rest.webservices.restfulwebservices.beans.HelloWorldBean;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloController {

	@GetMapping(path="/hello")
	public String helloWorld() {
		return "hello-world";
	}
	
	@GetMapping(path="/hellobean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path="/hello/path/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
//		throw new RuntimeException("Something went wrong");
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
