package com.funcity.service;

import java.util.List;

import com.funcity.dto.ActivityDTO;
import com.funcity.exception.ActivityException;
import com.funcity.exception.AdminException;
import com.funcity.model.Activity;
import com.funcity.model.Admin;

public interface AdminService {
	
	public Admin insertAdmin(Admin admin) throws AdminException;
	
	public Admin getAdmin(Integer id) throws AdminException;
	
	public Admin updateAdmin(Admin admin) throws AdminException;
	
	public Admin deleteAdmin(Integer admin_id) throws AdminException;
	
	public List<Activity> getAllActivities(Integer customer_id) throws ActivityException;
	
	public List<ActivityDTO> getAllActivities() throws ActivityException;
	
}
