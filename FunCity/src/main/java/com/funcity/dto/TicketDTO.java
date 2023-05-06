package com.funcity.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TicketDTO {

	 private Integer ticketId;
	 
	 private LocalDateTime dateTime=LocalDateTime.now();
	 
	 private Integer noOfPersons;
		
	 private Double total;
	 
	 private Integer cutomerId;
	 
	 private Integer activityId;
	 

	 
	 

}
