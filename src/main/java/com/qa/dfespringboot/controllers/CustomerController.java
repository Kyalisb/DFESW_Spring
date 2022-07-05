package com.qa.dfespringboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfespringboot.Customer;

// Handle incoming HTTP requests and send responses
//Uses JSON data
@RestController
@RequestMapping("/customer")
//RequestMapping adds a prefix to the request URLs

public class CustomerController {

//	Temporary storage, until the real database is implemented later
	private List<Customer> customers = new ArrayList<>();

//	GET - READ
//	What will be seen in the local host is "Hello" = localhost:8080/customer/hello
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

//	POST =CREATE
	@PostMapping("/create")
	public Customer create(@RequestBody Customer customer) {
		this.customers.add(customer);

//		When you want the latest entry added to the list
		return this.customers.get(this.customers.size() - 1);
	}

//	PUT - UPDATE

	
	
//	DELETE - DELETE

}
