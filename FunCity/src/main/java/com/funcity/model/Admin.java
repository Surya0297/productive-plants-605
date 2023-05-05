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
	private String phonenumber;
	
	@NotNull
	private String password;
	

	public Admin() {
		super();
	}

	public Admin(Integer admin_id, @NotNull String email, @NotNull String username, @NotNull String phonenumber,
			@NotNull String password) {
		super();
		this.admin_id = admin_id;
		this.email = email;
		this.username = username;
		this.phonenumber = phonenumber;
		this.password = password;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", email=" + email + ", username=" + username + ", phonenumber="
				+ phonenumber + ", password=" + password + "]";
	}

	
	
}
