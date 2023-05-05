package com.funcity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.funcity.dto.ActivityDTO;
import com.funcity.exception.ActivityException;
import com.funcity.model.Activity;
import com.funcity.model.UserSession;
import com.funcity.repository.ActivityRepository;
import com.funcity.repository.UserSessionRepository;

public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityRepository activityRepo;
	
	@Autowired
	private UserSessionRepository userSessionRepo;
	
	@Override
	public Activity insertActivity(String sessionId, Activity activity) throws ActivityException {
		
		UserSession us = userSessionRepo.findBySessionId(sessionId);
		if(us==null) {
		throw new ActivityException("Admin with session id not found");	
		}
		
		Activity savedActivity = activityRepo.save(activity);
		
		return savedActivity;
		
	}

	@Override
	public Activity updateActivity(String sid, Activity activity) throws ActivityException {
		
		UserSession us = userSessionRepo.findBySessionId(sid);
		if(us==null) {
		throw new ActivityException("Admin with session id Not found");	
		}
		
		Optional<Activity> opt = activityRepo.findById(activity.getActivityId());
		
		if(opt.isPresent()) {
			Activity act = opt.get();
			
			activityRepo.save(activity);
			
			return activity;
		}
		
		else throw new ActivityException("No Activity found with this Id: "+activity.getActivityId() );
	}

	@Override
	public Activity deleteActivity(String sid, Integer activityId) throws ActivityException {
		UserSession us = userSessionRepo.findBySessionId(sid);
		if(us==null) {
		throw new ActivityException("Admin with session id Not found");	
		}
		
		Optional<Activity> opt = activityRepo.findById(activityId);
		
		if(opt.isPresent()) {
			Activity act = opt.get();
			
			activityRepo.delete(act);
			
			return act;
		}
		
		else throw new ActivityException("No Activity found with this Id: "+activityId);
	}

	@Override
	public List<Activity> viewActivitiesByCharges(Double charges) throws ActivityException {
		List<Activity> activityList = activityRepo.findByCharges(charges);
		
		if(activityList.isEmpty()) {
			throw new ActivityException("There are no activities for given charge : "+charges);
		}
		
		else return activityList;
	}

	@Override
	public List<ActivityDTO> getAllActivities() {
		List<ActivityDTO> activityList = activityRepo.getActivityDetails();
		
		if(activityList.isEmpty()) throw new ActivityException("No Record Found");
		
		else return activityList;
	}
	
	public Integer getAllActivityCountByCharges(Double charges) {
		
		Integer count = activityRepo.countByCharges(charges);
		
		return count;
	}
	
	public Integer countActivityByCharges(Double charges) {
		Integer count=activityRepo.countByCharges(charges);
		return count;
		
	}

}
