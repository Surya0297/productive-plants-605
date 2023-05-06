package com.funcity.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.funcity.dto.CustomerDTO;
import com.funcity.dto.TicketDTO;
import com.funcity.model.Customer;
import com.funcity.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
		
	public List<Ticket> findByCustomer(Customer customer);
  
	public List<Ticket> findByDateTime(Customer customer);
	
	@Query("Select new com.funcity.dto.TicketDTO(ticketId,dateTime,noOfPersons,total) from Ticket")
	public List<TicketDTO> findAllTicketDetails();
	
	@Query("Select new com.funcity.dto.TicketDTO(ticketId,dateTime,noOfPersons,total) from Ticket where ticketId=?1")
	public TicketDTO findTicketDetailsById(Integer ticketId);

	public List<Ticket> findByCustomerAndDateTimeBetween(Customer customer,LocalDate startDate,LocalDate endDate);

}
