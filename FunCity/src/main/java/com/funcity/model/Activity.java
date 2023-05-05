package com.funcity.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	
	

	public Activity() {
		super();
		
	}

	public Activity(Integer activityId, String activityName, String description, String imageUrl1, String imageUrl2,
			Double charges, Integer thrillLevel, List<Ticket> tickets) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.description = description;
		this.imageUrl1 = imageUrl1;
		this.imageUrl2 = imageUrl2;
		this.charges = charges;
		this.thrillLevel = thrillLevel;
		this.tickets = tickets;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl1() {
		return imageUrl1;
	}

	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}

	public String getImageUrl2() {
		return imageUrl2;
	}

	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}

	public Double getCharges() {
		return charges;
	}

	public void setCharges(Double charges) {
		this.charges = charges;
	}

	public Integer getThrillLevel() {
		return thrillLevel;
	}

	public void setThrillLevel(Integer thrillLevel) {
		this.thrillLevel = thrillLevel;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", activityName=" + activityName + ", description=" + description
				+ ", imageUrl1=" + imageUrl1 + ", imageUrl2=" + imageUrl2 + ", charges=" + charges + ", thrillLevel="
				+ thrillLevel + "]";
	}
	
	

}
