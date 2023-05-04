package com.funcity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.funcity.model.Activity;
import com.funcity.model.ActivityDTO;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>{
	
	public List<Activity> findByCharges(Double charges);
	
	@Query("select new com.funcity.model.ActivityDTO(activityId, activityName,description,imageUrl1,imageUrl2,charges,thrillLevel) from Activity" )
	public List<ActivityDTO> getActivityDetails();
	
	public Integer countByCharges(Double Charges );
}
