package com.funcity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.funcity.dto.LoginUserDTO;
import com.funcity.exception.CustomerException;
import com.funcity.service.LoginUserService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginUserService loginUserService;
 
	@PostMapping("/login")
	public ResponseEntity<String> loginUserAccountHandler(@RequestBody LoginUserDTO loginUser) throws CustomerException {
		
		String userSessionId=loginUserService.logInUserAccount(loginUser);
		
		return new ResponseEntity<>(userSessionId,HttpStatus.CONTINUE);
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> loggedOutHandler(@RequestParam String sessionId) throws CustomerException{
		String logout=loginUserService.logOutUserAccount( sessionId);
		
		return new ResponseEntity<>(logout,HttpStatus.OK);
	}
	
}
