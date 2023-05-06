package com.funcity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Admin{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer admin_id;
	
	@Column(unique = true)
	@NotNull
	private String email;
	
	
	@NotNull
	private String username;
	
	@Column(unique = true)
	@NotNull
	private String mobileNumber;
	
	@NotNull
	private String password;
	

	
}
