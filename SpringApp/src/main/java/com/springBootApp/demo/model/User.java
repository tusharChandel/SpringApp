package com.springBootApp.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.springBootApp.demo.DTO.NewUserDTO;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "login id can't be empty")
	@Column(name = "login_id", length = 50, nullable = false, unique = true)
	private String loginId;

	@Size(min = 2, message = "Password should have atleast 2 characters")
	@Column(name = "password", length = 50, nullable = false, unique = false)
	private String password;

	@NotEmpty(message = "First Name can't be empty")
	@Column(name = "first_name", length = 50, nullable = false, unique = false)
	private String firstName;

	@NotEmpty(message = "Last Name can't be empty")
	@Column(name = "last_name", length = 50, nullable = false, unique = false)
	private String lastName;

	@Column(name = "city", length = 50, nullable = true, unique = false)
	private String city;

	@Column(name = "role", length = 50, nullable = false, unique = false)
	private String role;

	@CreationTimestamp
	@Column(name = "created_time_stamp", length = 50, nullable = false, unique = false)
	private Timestamp createdAt;

	public User() {

	}

	public User(NewUserDTO newUserDTO) {
		this.loginId = newUserDTO.getLoginId();
		this.password = newUserDTO.getPassword();
		this.firstName = newUserDTO.getFirstName();
		this.lastName = newUserDTO.getLastName();
		this.city = newUserDTO.getPlace();
		this.role = "USER";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

}