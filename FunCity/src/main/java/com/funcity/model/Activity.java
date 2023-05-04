package com.funcity.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activityId;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "Ticket_Activity", 
	        joinColumns = { @JoinColumn(name = "ticketId") }, 
	        inverseJoinColumns = { @JoinColumn(name = "activityId") }
	    )
	private List<Ticket> tickets;
	
}
