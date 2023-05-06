package com.funcity.dto;

import lombok.Data;

@Data
public class LoginUserDTO {
	
	private String mobileNumber;
	
	private String password;
	
	private String role;
	
	

	public LoginUserDTO() {
		super();
		
	}

	public LoginUserDTO(String mobileNumber, String password, String role) {
		super();
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.role = role;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginUserDTO [mobileNumber=" + mobileNumber + ", password=" + password + ", role=" + role + "]";
	}
	
	

	
}
