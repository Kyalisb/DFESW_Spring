package com.qa.dfespringboot.Service;


import java.util.List;

import org.springframework.stereotype.Service;


import com.qa.dfespringboot.Customer;
import com.qa.dfespringboot.repos.CustomerRepo;


@Service
public class CustomerService {
	
//	Temporary storage, until the real database is implemented later
//	private List<Customer> customers = new ArrayList<>();
	private CustomerRepo repo;
	
	public CustomerService(CustomerRepo repo) {
		this.repo = repo;
	}

//GET - READ ReadAll
	public List<Customer> readAll() {
		return this.repo.findAll();
	}

//	ReadByID
	public Customer readById(long id) {
		return this.repo.findById(id).get();
	}

//	POST =CREATE
	public Customer create(Customer customer) {
		return this.repo.saveAndFlush(customer);

//		When you want the latest entry added to the list
//		return this.customers.get(this.customers.size() - 1);
	}

//	PUT - UPDATE
	public Customer update(long id, Customer customer) {
//		step 2. Removing the original customer
//		step 3. to Repo	
//	step 2.	this.customers.remove(id);
//		Add the updated customer
//		this.customers.add(id, customer);
// Return the updated user
//		return this.customers.get(id);
		Customer existing = this.repo.findById(id).get();
//		Change the existing entry, using new customer object above
		existing.setFirstName(customer.getFirstName());
		existing.setLastName(customer.getLastName());
		existing.setEmail(customer.getEmail());

//		Save entry back into the database
		 return this.repo.saveAndFlush(existing);
		 
	}

//	DELETE - DELETE
	public boolean delete(long id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
		
	}

}

