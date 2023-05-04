package com.funcity.model;

import lombok.Data;

@Data
public class LoginUserDTO {
	
	private String mobileNumber;
	
	private String password;
	
	private String role;
	
}
