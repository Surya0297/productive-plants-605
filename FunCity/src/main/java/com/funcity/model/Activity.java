package com.funcity.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activityId;
	
	
	private String activityName;
	
	private String description;
	
	private String imageUrl1;
	
	private String imageUrl2;
	
	private Double charges;
	
	private Integer thrillLevel;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "activity")
	private List<Ticket> tickets;
	
}
