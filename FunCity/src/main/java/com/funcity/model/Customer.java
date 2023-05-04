package com.funcity.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

	@NotNull(message = "Name is mandatory")
	@NotEmpty(message = "Name can not be empty")
	@NotBlank(message = "Name can not be blank")
	@Size(min = 2, max = 15, message = " Name should be min of 2 characters and max upto 12 characters")
	private String customerName;

	@Email
	private String email;

	@Size(min = 10, message = "Mobile Number must be of 10 digits!")
	private String mobileNumber;

	@NotNull(message = "Address can not be null")
	@NotEmpty(message = "Address can not be empty")
	@NotBlank(message = "Address can not be blank")
	private String address;

	@NotNull(message = "Date of birth can not be null")
	private LocalDate dateOfBirth;

	@NotNull(message = "Username is Mandatory")
	@NotEmpty(message = "Username can not be empty")
	@NotBlank(message = "Username can not be blank")
	private String username;

	@NotNull(message = "Password can not be null")
	@NotEmpty(message = "Password can not be empty")
	@NotBlank(message = "Password can not be blank")
	@Size(min = 4, message = "Password must be of atleast 4 digits")
	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Ticket> tickets = new ArrayList<>();

	public Customer() {
		super();

	}

	public Customer(Integer customerId,
			@NotNull(message = "Name is mandatory") @NotEmpty(message = "Name can not be empty") @NotBlank(message = "Name can not be blank") @Size(min = 2, max = 12, message = " Name should be min of 2 characters and max upto 12 characters") String customerName,
			@Email String email, @Size(min = 10, message = "Mobile Number must be of 10 digits!") String mobileNumber,
			@NotNull(message = "Address can not be null") @NotEmpty(message = "Address can not be empty") @NotBlank(message = "Address can not be blank") String address,
			@NotNull(message = "Date of birth can not be null") LocalDate dateOfBirth,
			@NotNull(message = "Username is Mandatory") @NotEmpty(message = "Username can not be empty") @NotBlank(message = "Username can not be blank") String username,
			@NotNull(message = "Password can not be null") @NotEmpty(message = "Password can not be empty") @NotBlank(message = "Password can not be blank") @Size(min = 4, message = "Password must be of atleast 4 digits") String password,
			List<Ticket> tickets) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.username = username;
		this.password = password;
		this.tickets = tickets;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", address=" + address + ", dateOfBirth=" + dateOfBirth
				+ ", username=" + username + ", password=" + password + "]";
	}

}
