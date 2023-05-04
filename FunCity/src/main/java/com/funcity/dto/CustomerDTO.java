package com.funcity.dto;

import java.time.LocalDate;

public class CustomerDTO {

	private String customerName;

	private String email;

	private String username;

	private String mobileNumber;

	private String address;

	private LocalDate dateOfBirth;

	public CustomerDTO() {
		super();
	}

	public CustomerDTO(String customerName, String address, String mobileNumber,String username, String email, LocalDate dateOfBirth) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.username = username;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerName=" + customerName + ", email=" + email + ", username=" + username
				+ ", mobileNumber=" + mobileNumber + ", address=" + address + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
