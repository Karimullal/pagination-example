package com.pagination.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/sample")
public class SampleController {

	@GetMapping
	private String sayHello(@RequestParam("name") String name) {
		System.out.println("MOVED TO TOMCAT SERVER ............");
    		return "Hello "+name;
	}
	
	
}
