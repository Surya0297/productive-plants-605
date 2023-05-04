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
	
}
