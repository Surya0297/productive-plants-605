package com.funcity.service;

import java.util.List;

import com.funcity.dto.CustomerDTO;
import com.funcity.exception.CustomerException;
import com.funcity.model.Customer;

public interface CustomerService {

	public Customer registerCustomer(Customer customer) throws CustomerException;
	
	public List<CustomerDTO> findAllCustomers() throws CustomerException;
	
	public Customer deleteCustomer(Integer customerId) throws CustomerException;
	
	public Customer updateCustomer(Integer customerId,CustomerDTO cdto) throws CustomerException;
	
	public CustomerDTO findCustomerById(Integer customerId) throws CustomerException; 
	
	public Customer changePassword(Integer customerId,String oldpassword,String password) throws CustomerException;
	
}
