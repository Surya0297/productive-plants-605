package com.funcity.model;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;
	
	private LocalDateTime dateTime;
	
	private Integer noOfPersons;
	
	private Double total;

	@JsonIgnore
	@ManyToOne
	private Customer customer;

	@ManyToOne
	private Activity activity;

	
	public Ticket(){
		super();
		
	}

	public Ticket(Integer ticketId, LocalDateTime dateTime, Integer noOfPersons, Double total, Customer customer,
			Activity activity) {
		super();
		this.ticketId = ticketId;
		this.dateTime = dateTime;
		this.noOfPersons = noOfPersons;
		this.total = total;
		this.customer = customer;
		this.activity = activity;
	}

	
}
