package com.springBootApp.demo.DTO;

import javax.validation.constraints.NotEmpty;

public class NewUserDTO {

	@NotEmpty(message = "First Name can't be empty")
	private String firstName;

	@NotEmpty(message = "Last Name can't be empty")
	private String lastName;

	@NotEmpty(message = "Login Id can't be empty")
	private String loginId;

	@NotEmpty(message = "Password can't be empty")
	private String password;

	private String place;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
