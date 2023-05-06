package com.funcity.dto;

import lombok.Data;

@Data
public class ActivityDTO {
	
	private Integer activityId;
	
	
	private String activityName;
	
	private String description;
	
	private String imageUrl1;
	
	private String imageUrl2;
	
	private Double charges;
	
	private Integer thrillLevel;

	public ActivityDTO(Integer activityId, String activityName, String description, String imageUrl1, String imageUrl2,
			Double charges, Integer thrillLevel) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.description = description;
		this.imageUrl1 = imageUrl1;
		this.imageUrl2 = imageUrl2;
		this.charges = charges;
		this.thrillLevel = thrillLevel;
	}
	
	
}
