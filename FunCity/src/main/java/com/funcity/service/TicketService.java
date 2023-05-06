package com.funcity.service;

import java.util.List;

import com.funcity.dto.TicketDTO;
import com.funcity.exception.TicketException;
import com.funcity.model.Ticket;

public interface TicketService {
	 
	//public Ticket insertTicket(Ticket ticket) throws TicketException, CustomerException;
	
	public String deleteTicket(String sessionId,Integer ticketId) throws TicketException;
	
	public String updateTicket(String sessionId,Integer ticketId,Integer noOfPersons) throws TicketException;
	
	public List<TicketDTO> getAllTickets(String sessionId) throws TicketException;
	
	public TicketDTO getTicketsDetailsById(String sessionId,Integer TicketId) throws TicketException;
}
