package com.funcity.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activityId;
	
	@NotNull
	private String activityName;
	
	@NotNull
	@Size(min = 10,message="Description should be atleast 10 characters")
	private String description;

	@NotNull
	private String imageUrl1;
	
	@NotNull
	private String imageUrl2;
	
	@NotNull
	@Max(500)
	private Double charges;
	
	@NotNull
	@Max(5)
	private Integer thrillLevel;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "activity")
	private List<Ticket> tickets;
}
