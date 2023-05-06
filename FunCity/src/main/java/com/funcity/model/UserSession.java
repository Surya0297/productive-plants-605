package com.funcity.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserSession {
	
	@Id
	@Column(length = 20)
	private String mobileNumber;
	
	private String sessionId;
	
	private LocalDateTime logintime;
	
	private String role;
	
	

	
}
