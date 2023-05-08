package com.funcity.service;

import com.funcity.dto.LoginUserDTO;
import com.funcity.exception.CustomerException;
import com.funcity.model.UserSession;

public interface LoginUserService {
	
	public UserSession logInUserAccount(LoginUserDTO loginUser) throws CustomerException;
	
	public String logOutUserAccount(String sessionId) throws CustomerException;
	
	
}
