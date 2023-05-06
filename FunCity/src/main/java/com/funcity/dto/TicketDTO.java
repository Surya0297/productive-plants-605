package com.funcity.dto;

import java.time.LocalDateTime;

public class TicketDTO {

	 private Integer ticketId;
	 
	 private LocalDateTime dateTime;
	 
	 private Integer noOfPersons;
		
	 private Double total;

	public TicketDTO(Integer ticketId, LocalDateTime dateTime, Integer noOfPersons, Double total) {
		super();
		this.ticketId = ticketId;
		this.dateTime = dateTime;
		this.noOfPersons = noOfPersons;
		this.total = total;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getNoOfPersons() {
		return noOfPersons;
	}

	public void setNoOfPersons(Integer noOfPersons) {
		this.noOfPersons = noOfPersons;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "TicketDTO [ticketId=" + ticketId + ", dateTime=" + dateTime + ", noOfPersons=" + noOfPersons
				+ ", total=" + total + "]";
	}
	 
	 

}
