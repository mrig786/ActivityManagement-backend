package com.mrig.rest.webservices.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mrig.rest.basic.auth.AuthenticationBean;
import com.mrig.rest.webservices.restfulwebservices.beans.HelloWorldBean;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthController {

	
	@GetMapping(path="/basicauth")
	public AuthenticationBean authenticate() {
//		throw new RuntimeException("Something went wrong");
		System.out.println("Callled--------------------");
		return new AuthenticationBean("User is authentic");
	}
}
