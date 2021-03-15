package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
@RestController
public class ElasticSearchDemoApplication {
	
	@Autowired
	private CustomerRepository repository;
	
	@PostMapping("/saveCustomer")
	public int saveCustomer(@RequestBody List<Customer>customers)
	{
		repository.saveAll(customers);
		return customers.size();
	}
	
	@GetMapping("/findByFirstName/{firstName}")
	public List<Customer>findByFirstName(@PathVariable String firstName)
	{
		return repository.findByFirstName(firstName);
	}
	
	@GetMapping("/findAll")
	public Iterable<Customer>findAllCustomer()
	{
		return repository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchDemoApplication.class, args);
	}

}
