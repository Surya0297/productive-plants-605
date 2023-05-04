package com.funcity.model;

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
	
	private Double ticketBalance=399.99;

	@JsonIgnore
	@ManyToOne
	private Customer customer;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "tickets")
	private List<Activity> activities = new ArrayList<>();

	
	public Ticket() {
		super();
		
	}


	public Ticket(Integer ticketId, Double ticketBalance, Customer customer, List<Activity> activities) {
		super();
		this.ticketId = ticketId;
		this.ticketBalance = ticketBalance;
		this.customer = customer;
		this.activities = activities;
	}


	public Integer getTicketId() {
		return ticketId;
	}


	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}


	public Double getTicketBalance() {
		return ticketBalance;
	}


	public void setTicketBalance(Double ticketBalance) {
		this.ticketBalance = ticketBalance;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Activity> getActivities() {
		return activities;
	}


	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}


	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketBalance=" + ticketBalance + "]";
	}

	
}
