package com.funcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.funcity.dto.ActivityDTO;
import com.funcity.model.Activity;
import com.funcity.service.ActivityService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	
	@PostMapping("/activities/{sessionId}")
	public ResponseEntity<Activity> insertActivityHandler(@PathVariable String sessionId,@Valid @RequestBody Activity activity){
		
		Activity savedActivity=activityService.insertActivity(sessionId, activity);
		
		return new ResponseEntity<Activity>(savedActivity,HttpStatus.CREATED);
	}
	
	@PutMapping("/activities/{sessionId}")
	public ResponseEntity<Activity> updateActivityHandler(@PathVariable String sessionId,@Valid @RequestBody Activity activity){
		
		Activity updatedActivity = activityService.updateActivity(sessionId,activity);
				
		return new ResponseEntity<>(updatedActivity,HttpStatus.OK);
	}
	
	@DeleteMapping("/activities/{sessionId}/{activityId}")
	public ResponseEntity<Activity> deleteActivityHandler(@PathVariable String sessionId,@PathVariable Integer activityId){
		
		Activity activ = activityService.deleteActivity(sessionId,activityId);
		
		return new ResponseEntity<>(activ,HttpStatus.OK);
	}
	
	@GetMapping("/activities")
	public ResponseEntity<List<ActivityDTO>> getAllActivitiesHandler(){
		
		List<ActivityDTO> activityList =activityService.getAllActivities();
		
		return new ResponseEntity<List<ActivityDTO>>(activityList, HttpStatus.OK);
		
	}
	
	@GetMapping("/activities/{charges}")
	public ResponseEntity<List<Activity>> viewActivitiesByChargesHandler(@PathVariable Double charges){
		
		List<Activity> activities = activityService.viewActivitiesByCharges(charges);
		
		return new ResponseEntity<>(activities,HttpStatus.OK);
	}
	
	@GetMapping("/activities/count/{charges}")
	public ResponseEntity<Integer> countActivityByChargesHandler(@PathVariable Double charges){
		
		Integer count = activityService.getAllActivityCountByCharges(charges);
		
		return new ResponseEntity<>(count,HttpStatus.OK);
	}
	
}
