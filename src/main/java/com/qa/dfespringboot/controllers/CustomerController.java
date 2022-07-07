package com.qa.dfespringboot.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfespringboot.Customer;
import com.qa.dfespringboot.Service.CustomerService;

// Handle incoming HTTP requests and send responses
//Uses JSON data
@RestController
@RequestMapping("/customer")
//RequestMapping adds a prefix to the request URLs

public class CustomerController {
	
	private CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}

//	GET - READ
//	What will be seen in the local host is "Hello" = localhost:8080/customer/hello
//	@GetMapping("/hello")
//	public String hello() {
//		return "Hello";
//	}

//ReadAll
	@GetMapping("/readAll")
	public List<Customer> readAll() {
		return this.service.readAll();
	}

//	ReadByID
	@GetMapping("/readById/{id}")
	public Customer readById(@PathVariable long id) {
		return this.service.readById(id);
	}
	

//	POST =CREATE
	@PostMapping("/create")
	public Customer create(@RequestBody Customer customer) {
		return this.service.create(customer);
	}
	

////		When you want the latest entry added to the list
//		return this.customers.get(this.customers.size() - 1);
	

//	PUT - UPDATE
	@PutMapping("/update/{id}")
	public Customer update(@PathVariable long id, @RequestBody Customer customer) {
//		Removing the original customer
		return this.service.update(id, customer);

//		Add the updated customer
//		this.customers.add(id, customer);

//		return this.customers.get(id);
	}

//	DELETE - DELETE
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return this.service.delete(id);

	}

}
