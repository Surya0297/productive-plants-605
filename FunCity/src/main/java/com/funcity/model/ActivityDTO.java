package com.funcity.model;

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
	
}
