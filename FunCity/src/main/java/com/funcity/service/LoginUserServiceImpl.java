//package com.funcity.service;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.funcity.exception.AdminException;
//import com.funcity.model.Admin;
//import com.funcity.model.Customer;
//import com.funcity.model.LoginUserDTO;
//import com.funcity.model.UserSession;
//import com.funcity.repository.AdminRepository;
//import com.funcity.repository.UserSessionRepository;
//import net.bytebuddy.utility.RandomString;
//
//@Service
//public class LoginUserServiceImpl implements LoginUserService{

//	@Autowired
//	private CustomerRepository customerRepository;
	
//	@Autowired
//	private AdminRepository adminRepository;
//	
//	@Autowired
//	private UserSessionRepository userSessionRepository;
	
//	@Override
//	public String logInUserAccount(LoginUserDTO loginUser) {
//
//		String role = loginUser.getRole();
//		String mobileNumber = loginUser.getMobileNumber();
//		
//		if(role.equalsIgnoreCase("customer")) {
//			Customer c = customerRepository.findBymobileNumber(mobileNumber);
//			if(c==null) {
//				throw new CustomerException("customer not found with mobileNumber " + mobileNumber);
//			}
//			if(c.getPassword().equalsIgnoreCase(loginUser.getPassword())==false) {
//				throw new CustomerException("Incorrect password");
//			}
//			
//			Optional<UserSession> opt2 = userSessionRepository.findById(mobileNumber);
//			if(opt2.isPresent() && opt2.get().getRole().equalsIgnoreCase(role)) {
//				throw new CustomerException("Already logged in");
//			}
//			
//			String sessionId = RandomString.make(6);
//			
//			UserSession us = new UserSession();
//			us.setSessionId(sessionId);
//			us.setPhoneNumber(mobileNumber);
//			us.setLogintime(LocalDateTime.now());
//			us.setRole(role);
//			userSessionRepository.save(us);
//			return sessionId;
//		}else {
//			Admin a = adminRepository.findByphonenumber(mobileNumber);
//			if(a==null) {
//				throw new AdminException("admin not found with mobileNumber " + mobileNumber);
//			}
//			if(a.getPassword().equalsIgnoreCase(loginUser.getPassword())==false) {
//				throw new CustomerException("Incorrect password");
//			}
//			
//			Optional<UserSession> opt2 = userSessionRepository.findById(mobileNumber);
//			if(opt2.isPresent() && opt2.get().getRole().equalsIgnoreCase(role)) {
//				throw new CustomerException("Already logged in");
//			}
//			
//			String sessionId = RandomString.make(5);
//			
//			UserSession us = new UserSession();
//			us.setSessionId(sessionId);
//			us.setPhoneNumber(mobileNumber);
//			us.setLogintime(LocalDateTime.now());
//			us.setRole(role);
//			userSessionRepository.save(us);
//			return sessionId;
//		}
//		
//	}
//
//	@Override
//	public String logOutUserAccount(String mobileNumber, String sessionId) {
//		UserSession us = userSessionRepository.findBySessionId(sessionId);
//		if(us==null) {
//			throw new CustomerException("user not found with sessioId " + sessionId);
//		}
//		userSessionRepository.delete(us);
//		return "successfully logged out";
//	}

//}
