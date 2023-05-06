package com.funcity.service;

import java.time.LocalDate;
import java.util.List;

import com.funcity.dto.ActivityDTO;
import com.funcity.dto.AdminDTO;
import com.funcity.exception.ActivityException;
import com.funcity.exception.AdminException;
import com.funcity.exception.CustomerException;
import com.funcity.model.Activity;
import com.funcity.model.Admin;

public interface AdminService {
	
	public Admin insertAdmin(Admin admin) throws AdminException;
	
	public Admin getAdmin(String sessionId,Integer id) throws AdminException;
	
	public Admin updateAdmin(String sessionId,Integer adminId,AdminDTO adminDto) throws AdminException ;
	
	public Admin deleteAdmin(String sessionId,Integer admin_id) throws AdminException;
	
	public List<Activity> getAllActivities(String sessionId,Integer customer_id) throws AdminException,ActivityException, CustomerException;
	
	public List<ActivityDTO> getAllActivities() throws ActivityException;

	public List<Activity> getAllActivitiesBetweenDatesByCutomerId(String sessionId, Integer customer_id,LocalDate startDate,LocalDate endDate)
			throws AdminException,ActivityException, CustomerException;
	
}
