package com.funcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.funcity.dto.TicketDTO;
import com.funcity.exception.TicketException;
import com.funcity.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	private TicketService tservice;

//	@PostMapping("/tickets")
//	public ResponseEntity<Ticket> insertTicketHandler(@RequestBody Ticket ticket) throws TicketException, CustomerException{
//		Ticket ticket1=tservice.insertTicket( ticket);
//		
//		return new ResponseEntity<>(ticket1,HttpStatus.CREATED);
//		
//	}
	
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
		
		return new ResponseEntity<>(tdto,HttpStatus.OK);
		
	}
	
}
