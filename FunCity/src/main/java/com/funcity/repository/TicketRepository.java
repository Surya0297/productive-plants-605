package com.funcity.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funcity.model.Customer;
import com.funcity.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
		
	public List<Ticket> findByCustomer(Customer customer);
	public List<Ticket> findByCustomerAndDateTimeBetween(Customer customer,LocalDate startDate,LocalDate endDate);
}
