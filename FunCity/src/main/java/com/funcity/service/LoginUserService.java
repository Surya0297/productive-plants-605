package com.funcity.service;

import com.funcity.dto.LoginUserDTO;
import com.funcity.exception.CustomerException;

public interface LoginUserService {
	
	public String logInUserAccount(LoginUserDTO loginUser) throws CustomerException;
	
	public String logOutUserAccount(String sessionId) throws CustomerException;
	
	
}
