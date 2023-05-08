package com.funcity.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.funcity.dto.AdminDTO;
import com.funcity.exception.ActivityException;
import com.funcity.exception.AdminException;
import com.funcity.exception.CustomerException;
import com.funcity.model.Activity;
import com.funcity.model.Admin;
import com.funcity.service.AdminService;
import com.funcity.service.TicketService;

import jakarta.validation.Valid;



@RestController
@CrossOrigin("*")
public class AdminController {
	
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/admins")
	public ResponseEntity<Admin> insertAdminHandler(@Valid @RequestBody Admin admin){
		Admin a = adminService.insertAdmin(admin);
		return new ResponseEntity<Admin>(a, HttpStatus.OK);
		
	}
	
	@GetMapping("/admins/{sessionId}/{id}")
	public ResponseEntity<Admin> getAdminHandler(@PathVariable String sessionId,@PathVariable Integer id){
		Admin a = adminService.getAdmin(sessionId, id);
		return new ResponseEntity<Admin>(a, HttpStatus.OK);
	}
	
	@PutMapping("/admins/{sessionId}/{adminId}")
	public ResponseEntity<Admin> updateAdminHandler(@PathVariable String sessionId,@PathVariable Integer adminId,@Valid @RequestBody AdminDTO adminDTO){
		Admin a = adminService.updateAdmin(sessionId,adminId,adminDTO);
		return new ResponseEntity<Admin>(a, HttpStatus.OK);
	}
	
	@DeleteMapping("/admins/{sessionId}/{id}")
	public ResponseEntity<Admin> deleteAdminHandler(@PathVariable String sessionId,@PathVariable Integer id){
		Admin a = adminService.deleteAdmin(sessionId,id);
		return new ResponseEntity<Admin>(a, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customeractivities/{sessionId}/{customerId}")
	public ResponseEntity<List<Activity>> getAllActivtiesOfACustomerHandler(@PathVariable String sessionId,@PathVariable Integer customerId) throws AdminException, ActivityException, CustomerException{
		
		List<Activity> activities = adminService.getAllActivities(sessionId,customerId);
		
		return new ResponseEntity<List<Activity>>(activities, HttpStatus.OK);
	}
	
	@GetMapping("/allActivities")
	public ResponseEntity<List<ActivityDTO>> getAllActivtiesHandler(){
		
		List<ActivityDTO> activities = adminService.getAllActivities();
		
		return new ResponseEntity<List<ActivityDTO>>(activities, HttpStatus.OK);
	}
	
	@GetMapping("/activities/{sessionId}/{customerId}/{startDate}/{endDate}")
	public ResponseEntity<List<Activity>> getActivitiesForCustomerInDateRange(

			@PathVariable String sessionId,
			@PathVariable Integer customerId,
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) throws AdminException, ActivityException, CustomerException {

	    LocalDateTime lowerBoundDate = startDate.atStartOfDay();
	    LocalDateTime upperBoundDate = endDate.plusDays(1).atStartOfDay().minusSeconds(1);

	    List<Activity> activities = adminService.getAllActivitiesBetweenDatesByCutomerId(sessionId,customerId, lowerBoundDate, upperBoundDate);
	    return ResponseEntity.ok(activities);
	}
	
	
}
