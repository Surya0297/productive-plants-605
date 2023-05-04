package com.funcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.funcity.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	public Admin findByphonenumber(String mobileNumber);

}
