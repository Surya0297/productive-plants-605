package com.funcity.service;

import com.funcity.model.LoginUserDTO;

public interface LoginUserService {
	
	public String logInUserAccount(LoginUserDTO loginUser);
	
	public String logOutUserAccount(String mobileNumber,String sessionId);
	
	
}
