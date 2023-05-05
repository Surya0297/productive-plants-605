package com.funcity.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserSession {
	
	@Id
	private String phoneNumber;
	
	private String sessionId;
	
	private LocalDateTime logintime;
	
	private String role;
	
	

	public UserSession() {
		super();
		
	}

	public UserSession(String phoneNumber, String sessionId, LocalDateTime logintime, String role) {
		super();
		this.phoneNumber = phoneNumber;
		this.sessionId = sessionId;
		this.logintime = logintime;
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public LocalDateTime getLogintime() {
		return logintime;
	}

	public void setLogintime(LocalDateTime logintime) {
		this.logintime = logintime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserSession [phoneNumber=" + phoneNumber + ", sessionId=" + sessionId + ", logintime=" + logintime
				+ ", role=" + role + "]";
	}
	
	
	
}
