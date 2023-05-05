package com.funcity.service;

import java.util.List;

import com.funcity.dto.ActivityDTO;
import com.funcity.exception.ActivityException;
import com.funcity.model.Activity;

public interface ActivityService {
	
	public Activity insertActivity(String sid,Activity activity) throws ActivityException;
	
	public Activity updateActivity(String sid,Activity activity) throws ActivityException;
	
	public Activity deleteActivity(String sid,Integer activityId) throws ActivityException;
	
	public List<Activity> viewActivitiesByCharges(Double charges) throws ActivityException;
	
	public List<ActivityDTO> getAllActivities();
	
	public Integer getAllActivityCountByCharges(Double charges);
}
