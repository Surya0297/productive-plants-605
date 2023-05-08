package com.funcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.funcity.dto.TicketDTO;
import com.funcity.exception.CustomerException;
import com.funcity.exception.TicketException;
import com.funcity.model.Ticket;
import com.funcity.service.TicketService;

@RestController
@CrossOrigin("*")
public class TicketController {
	
	@Autowired
	private TicketService tservice;

	@PostMapping("/tickets/{sessionId}")
	public ResponseEntity<Ticket> insertTicketHandler(@PathVariable String sessionId,@RequestBody TicketDTO ticketDTO) throws TicketException, CustomerException{
		Ticket ticket1=tservice.insertTicket(sessionId,ticketDTO);
		
		return new ResponseEntity<>(ticket1,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/tickets/{ticketId}")
	public ResponseEntity<String> deleteTicketHandler(@RequestParam String sessionId,@PathVariable Integer ticketId) throws TicketException{
		String res=tservice.deleteTicket(sessionId, ticketId);
		
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@GetMapping("/tickets")
	public ResponseEntity<List<TicketDTO>> getAllTicketHandler(@RequestParam String sessionId){
		
		List<TicketDTO> tlist=tservice.getAllTickets( sessionId);
		
		return new ResponseEntity<>(tlist,HttpStatus.OK);
		
	}
	
	@PatchMapping("/tickets/{ticketId}/{noOfPersons}")
	public ResponseEntity<String> updateTicketHandler(@RequestParam String sessionId,@PathVariable Integer ticketId,@PathVariable Integer noOfPersons){
		String res=tservice.updateTicket(sessionId,ticketId, noOfPersons);
		
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@GetMapping("/gettickets/{TicketId}")
	public ResponseEntity<TicketDTO> getTicketByIdHandler(@RequestParam String sessionId,@PathVariable Integer TicketId)throws TicketException{
		
		
		TicketDTO tdto=tservice.getTicketsDetailsById(sessionId,TicketId);
		System.out.println(tdto);
		return new ResponseEntity<>(tdto,HttpStatus.OK);
		
	}
	
	@GetMapping("/calculateBill/{sessionId}/{customerId}")
	public ResponseEntity<Double> getTotalBillIdHandler(@PathVariable String sessionId,@PathVariable Integer customerId)throws TicketException, CustomerException{
		
		Double total=tservice.getTotalBill(sessionId, customerId);
		
		return new ResponseEntity<>(total,HttpStatus.OK);
		
	}
	
	@GetMapping("/ticketsofcustomer/{sessionId}/{customerId}")
	public ResponseEntity<List<TicketDTO>> getTicketOfCustomerHandler(@PathVariable String sessionId,@PathVariable Integer customerId)throws TicketException, CustomerException{
		
		List<TicketDTO> list=tservice.getTicketOfCustomer(sessionId, customerId);
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
}
