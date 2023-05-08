package com.funcity.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.funcity.dto.CustomerDTO;
import com.funcity.dto.TicketDTO;
import com.funcity.model.Customer;
import com.funcity.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
		
	public List<Ticket> findByCustomer(Customer customer);
  
	public List<Ticket> findByDateTime(Customer customer);
	
	@Query("Select new com.funcity.dto.TicketDTO(ticketId,dateTime,noOfPersons,total,customer.customerId,activity.activityId) from Ticket")
	public List<TicketDTO> findAllTicketDetails();
	
	@Query("Select new com.funcity.dto.TicketDTO(ticketId,dateTime,noOfPersons,total,customer.customerId,activity.activityId) from Ticket where ticketId=?1")
	public TicketDTO findTicketDetailsById(Integer ticketId);
	
	 @Query("SELECT t FROM Ticket t WHERE t.customer.customerId = :customerId AND t.dateTime >= :lowerBoundDate AND t.dateTime <= :upperBoundDate")
	List<Ticket> findByCustomerIdAndDateRange(@Param("customerId") long customerId, @Param("lowerBoundDate") LocalDateTime lowerBoundDate, @Param("upperBoundDate") LocalDateTime upperBoundDate);

}
