package com.funcity.model;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;
	
	@Temporal(TemporalType.TIMESTAMP) 
	private LocalDateTime dateTime;
	
	private Integer noOfPersons;
	
	private Double total=0.0;

	@JsonIgnore
	@ManyToOne
	private Customer customer;
	
	
	@ManyToOne
	private Activity activity;
	
	
}
