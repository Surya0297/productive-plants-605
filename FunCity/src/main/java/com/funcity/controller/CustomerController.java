package com.funcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.funcity.dto.CustomerDTO;
import com.funcity.exception.CustomerException;
import com.funcity.model.Customer;
import com.funcity.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customers")
	public ResponseEntity<Customer> registerCustomerHandler(@Valid @RequestBody Customer customer)
			throws CustomerException {

		Customer cust = customerService.registerCustomer(customer);

		return new ResponseEntity<>(cust, HttpStatus.CREATED);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDTO>> findAllCustomerHandler() throws CustomerException {

		List<CustomerDTO> customerList = customerService.findAllCustomers();

		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<Customer> deleteCustomerHandler(@PathVariable Integer customerId) throws CustomerException {

		Customer deletedCustomer = customerService.deleteCustomer(customerId);

		return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
	}

	@PostMapping("/updateCustomers/{customerId}")
	public ResponseEntity<Customer> updateCustomerHandler(@PathVariable Integer customerId,
			@RequestBody CustomerDTO cdto) throws CustomerException {
		Customer customer = customerService.updateCustomer(customerId, cdto);

		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}

	@GetMapping("/customers/{customerId}")
	public ResponseEntity<CustomerDTO> findCustomerByIdHandler(@PathVariable Integer customerId)
			throws CustomerException {
		CustomerDTO customer = customerService.findCustomerById(customerId);

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PatchMapping("/customers/{customerId}/{oldpassword}/{password}")
	public ResponseEntity<Customer> changepasswordHandler(@PathVariable Integer customerId,
			@PathVariable String oldpassword, @PathVariable String password) throws CustomerException {
		Customer customer = customerService.changePassword(customerId, oldpassword, password);

		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}

}
