package com.funcity.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TicketDTO {

	 private Integer ticketId;
	 
	 private LocalDateTime dateTime;
	 
	 private Integer noOfPersons;
		
	 private Double total;
	 
	 private Integer customerId;
	 
	 private Integer activityId;

	public TicketDTO(Integer ticketId, LocalDateTime dateTime, Integer noOfPersons, Double total, Integer customerId,
			Integer activityId) {
		super();
		this.ticketId = ticketId;
		this.dateTime = dateTime;
		this.noOfPersons = noOfPersons;
		this.total = total;
		this.customerId = customerId;
		this.activityId = activityId;
	}
	 
	 
	 
	 

}
