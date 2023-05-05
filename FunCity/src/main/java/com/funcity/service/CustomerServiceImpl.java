package com.funcity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funcity.dto.CustomerDTO;
import com.funcity.exception.CustomerException;
import com.funcity.model.Customer;
import com.funcity.model.Ticket;
import com.funcity.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {

		if (customer == null)
			throw new CustomerException("Customer object can not be null");

		List<Ticket> ticketList = customer.getTickets();

		for (Ticket ticket : ticketList) {
			ticket.setCustomer(customer);
		}

		return customerRepo.save(customer);

	}

	@Override
	public List<CustomerDTO> findAllCustomers() throws CustomerException {

		List<CustomerDTO> customerList = customerRepo.findAllCustomerDetails();

		if (customerList.isEmpty()) {
			throw new CustomerException("No customer is present");
		} else
			return customerList;
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException {

		Customer existingCustomer = customerRepo.findById(customerId)
				.orElseThrow(() -> new CustomerException("No customer present with customerId : " + customerId));

		customerRepo.delete(existingCustomer);

		return existingCustomer;
	}

	@Override
	public Customer updateCustomer(Integer customerId, CustomerDTO cdto) throws CustomerException {

		Customer existingCustomer = customerRepo.findById(customerId)
				.orElseThrow(() -> new CustomerException("No customer present with customerId : " + customerId));

		existingCustomer.setCustomerName(cdto.getCustomerName());
		existingCustomer.setAddress(cdto.getAddress());
		existingCustomer.setDateOfBirth(cdto.getDateOfBirth());
		existingCustomer.setEmail(cdto.getEmail());
		existingCustomer.setMobileNumber(cdto.getMobileNumber());
		existingCustomer.setUsername(cdto.getUsername());

		return customerRepo.save(existingCustomer);

	}

	@Override
	public CustomerDTO findCustomerById(Integer customerId) throws CustomerException {

		CustomerDTO customerDTO = customerRepo.findCustomerDetailById(customerId);

		if (customerDTO == null)
			throw new CustomerException("No customer present with customerId : " + customerId);

		else
			return customerDTO;
	}

	@Override
	public Customer updatePassword(Integer customerId,String oldpassword, String password) throws CustomerException {
		Customer existingcustomer = customerRepo.findById(customerId)
				.orElseThrow(() -> new CustomerException("No customer present with this customerId : " + customerId));

		if(existingcustomer.getPassword().equals(oldpassword)) {
		
		existingcustomer.setPassword(password);
		return customerRepo.save(existingcustomer);
		
		}else
			throw new CustomerException("Please provide valid old password to change the password");

		
	}

}
