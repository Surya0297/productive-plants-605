package com.funcity.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funcity.dto.ActivityDTO;
import com.funcity.dto.AdminDTO;
import com.funcity.exception.ActivityException;
import com.funcity.exception.AdminException;
import com.funcity.exception.CustomerException;
import com.funcity.model.Activity;
import com.funcity.model.Admin;
import com.funcity.model.Customer;
import com.funcity.model.Ticket;
import com.funcity.model.UserSession;
import com.funcity.repository.ActivityRepository;
import com.funcity.repository.AdminRepository;
import com.funcity.repository.CustomerRepository;
import com.funcity.repository.TicketRepository;
import com.funcity.repository.UserSessionRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private TicketRepository ticketRepo;
	
	@Autowired
	private ActivityRepository activityRepo;
	
	@Autowired
	private UserSessionRepository userSessionRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Admin insertAdmin(Admin admin) throws AdminException {
		
		Admin savedAdmin = adminRepo.save(admin);
		
		return savedAdmin;
	}

	@Override
	public Admin getAdmin(String sessionId,Integer id) throws AdminException {
		UserSession us = userSessionRepo.findBySessionId(sessionId);
		if(us==null) {
		throw new AdminException("Admin with session id not found");	
		}
		Optional<Admin> opt = adminRepo.findById(id);
		if(opt.isPresent()) {
			Admin admin = opt.get();
			return admin;
		}
		throw new AdminException("Admin not found with id " + id);
	}
		

	@Override
	public Admin updateAdmin(String sessionId,Integer adminId,AdminDTO adminDto) throws AdminException {
		UserSession us = userSessionRepo.findBySessionId(sessionId);
		if(us==null) {
		throw new AdminException("Admin with session id not found");	
		}
		Optional<Admin> opt = adminRepo.findById(adminId);
		if(opt.isPresent()) {
			Admin a1 = opt.get();
			a1.setEmail(adminDto.getEmail());
			a1.setMobileNumber(adminDto.getMobileNumber());
			a1.setUsername(adminDto.getUsername());
			a1.setPassword(adminDto.getPassword());
			adminRepo.save(a1);
			return a1;
		}
		throw new AdminException("Admin not found with id " + adminId);
	}

	@Override
	public Admin deleteAdmin(String sessionId,Integer admin_id) throws AdminException {
		UserSession us = userSessionRepo.findBySessionId(sessionId);
		if(us==null) {
		throw new AdminException("Admin with session id not found");	
		}
		Optional<Admin> opt = adminRepo.findById(admin_id);
		if(opt.isPresent()) {
			Admin a1 = opt.get();
			adminRepo.delete(a1);
			return a1;
		}
		throw new AdminException("Admin not found with id " + admin_id);
	}

	@Override
	public List<Activity> getAllActivities(String sessionId,Integer customer_id) throws ActivityException, CustomerException{
		UserSession us = userSessionRepo.findBySessionId(sessionId);
		if(us==null) {
		throw new AdminException("Admin with session id not found");	
		}
		Optional<Customer> opt = customerRepo.findById(customer_id);
		if(opt.isPresent()==false) {
			throw new CustomerException("customer not found with id " + customer_id);
		}
		
			Customer c = opt.get();
			List<Ticket> tickets = ticketRepo.findByCustomer(c);
			List<Activity> activities=new ArrayList();
			if(tickets.size() == 0) {
				throw new ActivityException("customer has not taken any activity yet");
			}else {
				
				for(Ticket t:tickets) {
					activities.add(t.getActivity());
				}
			}
			
			
			return activities;
	}

	@Override
	public List<ActivityDTO> getAllActivities() throws ActivityException {
		
		List<ActivityDTO> activityList = activityRepo.getActivityDetails();
		
		if(activityList.isEmpty()) throw new ActivityException("No Record Found");
		
		return activityList;
	}

	@Override
	public List<Activity> getAllActivitiesBetweenDatesByCutomerId(String sessionId, Integer customer_id,
			LocalDateTime lowerBoundDate, LocalDateTime upperBoundDate)
			throws AdminException, ActivityException, CustomerException {
		UserSession us = userSessionRepo.findBySessionId(sessionId);
		if(us==null) 
		throw new AdminException("Admin with session id not found");	
		
		Optional<Customer> opt = customerRepo.findById(customer_id);
		if(opt.isPresent()==false) {
			throw new CustomerException("customer not found with id " + customer_id);
		}
		
			Customer c = opt.get();
		List<Ticket> tickets = ticketRepo.findByCustomerIdAndDateRange(customer_id, lowerBoundDate, upperBoundDate);
		Set<Activity> activities=new HashSet<>();
		if(tickets.size() == 0) {
			throw new ActivityException("customer has not taken any activity yet");
		}else {
			
			for(Ticket t:tickets) {
				activities.add(t.getActivity());
			}
		}
		List<Activity> list = new ArrayList<>(activities);
		
		return list;
	
	}

	
	
}


	

