package com.springBootApp.demo.DTO;

import com.springBootApp.demo.model.User;

public class UserDTO {

	private String loginId;
	private String firstName;
	private String lastName;
	private String city;

	public UserDTO() {
		
	}
	public UserDTO(User userEntity) {
		this.firstName = userEntity.getFirstName();
		this.lastName = userEntity.getLastName();
		this.loginId = userEntity.getLoginId();
		this.city = userEntity.getCity();
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
