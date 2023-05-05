package com.funcity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.funcity.dto.CustomerDTO;
import com.funcity.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    
	@Query("Select new com.funcity.dto.CustomerDTO(customerName,address,mobileNumber,username,email,dateOfBirth) from Customer")
	public List<CustomerDTO> findAllCustomerDetails();
	
	@Query("Select new com.funcity.dto.CustomerDTO(customerName,address,mobileNumber,username,email,dateOfBirth) from Customer Where customerId=?1")
	public CustomerDTO findCustomerDetailById(Integer customerId);
	
	public Customer findByMobileNumber(String mobileNumber );
}
