package com.funcity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funcity.dto.TicketDTO;
import com.funcity.exception.ActivityException;
import com.funcity.exception.CustomerException;
import com.funcity.exception.TicketException;
import com.funcity.model.Activity;
import com.funcity.model.Customer;
import com.funcity.model.Ticket;
import com.funcity.model.UserSession;
import com.funcity.repository.ActivityRepository;
import com.funcity.repository.CustomerRepository;
import com.funcity.repository.TicketRepository;
import com.funcity.repository.UserSessionRepository;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private ActivityRepository arepo;
	
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

	@Override
	public Ticket insertTicket(String sessionId,TicketDTO ticketDTO) throws TicketException, CustomerException {
		UserSession us = userSessionRepo.findBySessionId(sessionId);
		if (us == null) {
			throw new TicketException("Admin with session id not found");
		}
		Customer customer = crepo.findById(ticketDTO.getCustomerId())
                .orElseThrow(() -> new CustomerException("Customer not found with ID " + ticketDTO.getCustomerId()));

        Activity activity = arepo.findById(ticketDTO.getActivityId())
                .orElseThrow(() -> new ActivityException("Activity not found with ID " + ticketDTO.getActivityId()));

        Ticket ticket1 = new Ticket();
        ticket1.setDateTime(ticketDTO.getDateTime());
        ticket1.setNoOfPersons(ticketDTO.getNoOfPersons());
   
        ticket1.setCustomer(customer);
        ticket1.setActivity(activity);
        
        ticket1.setTotal(activity.getCharges()*ticketDTO.getNoOfPersons());
        
        Ticket savedTicket = trepo.save(ticket1);
        return savedTicket;
	}

	@Override
	public Double getTotalBill(String sessionId, Integer customerId) throws CustomerException {
		UserSession us = userSessionRepo.findBySessionId(sessionId);
		if (us == null) {
			throw new TicketException("Admin with session id not found");
		}
		Customer customer = crepo.findById(customerId).orElseThrow(()->new CustomerException("No Customer With Customer Id: "+customerId));
		
		List<Ticket> tickets=trepo.findByCustomer(customer);
		if(tickets.isEmpty())throw new ActivityException("No Activity Selected So far");
		
		Double total=0.0;
		
		for(Ticket t:tickets) {
			total+=t.getTotal();
		}
		
		return total;
	}

	@Override
	public List<TicketDTO> getTicketOfCustomer(String sessionId, Integer customerId) throws TicketException {
		// TODO Auto-generated method stub
		UserSession us = userSessionRepo.findBySessionId(sessionId);
		if (us == null) {
			throw new TicketException("Customer with session id not found");
		}
		List<TicketDTO> list=trepo.getTicketByCustomerId(customerId);
		if(list.isEmpty())throw new TicketException("No Ticket Found");
		return list;
	}

}
