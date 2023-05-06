package com.funcity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funcity.dto.TicketDTO;
import com.funcity.exception.ActivityException;
import com.funcity.exception.CustomerException;
import com.funcity.exception.TicketException;
import com.funcity.model.Customer;
import com.funcity.model.Ticket;
import com.funcity.model.UserSession;
import com.funcity.repository.CustomerRepository;
import com.funcity.repository.TicketRepository;
import com.funcity.repository.UserSessionRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private CustomerRepository crepo;

	@Autowired
	private TicketRepository trepo;
	@Autowired
	private UserSessionRepository userSessionRepo;

	@Override
	public String deleteTicket(String sessionId, Integer ticketId) throws TicketException {
		UserSession us = userSessionRepo.findBySessionId(sessionId);
		if (us == null) {
			throw new TicketException("Admin with session id not found");
		}
		Ticket existticket = trepo.findById(ticketId).orElseThrow(() -> new TicketException("Ticket not found"));

		trepo.delete(existticket);

		return "Deleted Successfully";
	}

	@Override
	public String updateTicket(String sessionId, Integer ticketId, Integer noOfPersons) throws TicketException {

		UserSession us = userSessionRepo.findBySessionId(sessionId);
		if (us == null) {
			throw new TicketException("Admin with session id not found");
		}

		Ticket existticket = trepo.findById(ticketId)
				.orElseThrow(() -> new TicketException("No ticket present with ticketId : " + ticketId));

		existticket.setNoOfPersons(noOfPersons);
		trepo.save(existticket);
		return "Ticket updated Successfully";

	}

	@Override
	public TicketDTO getTicketsDetailsById(String sessionId, Integer TicketId) throws TicketException {
		UserSession us = userSessionRepo.findBySessionId(sessionId);
		if (us == null) {
			throw new TicketException("Admin with session id not found");
		}
		TicketDTO existTicket = trepo.findTicketDetailsById(TicketId);
		if (existTicket == null)
			throw new TicketException("No Ticket is avaialble with ticket id : " + TicketId);
		return existTicket;
	}

	@Override
	public List<TicketDTO> getAllTickets(String sessionId) throws TicketException {
		UserSession us = userSessionRepo.findBySessionId(sessionId);
		if (us == null) {
			throw new TicketException("Admin with session id not found");
		}
		List<TicketDTO> tlist = trepo.findAllTicketDetails();
		if (tlist.isEmpty()) {
			throw new TicketException("No ticket present");
		}
		return tlist;

	}

}
