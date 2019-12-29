package com.springBootApp.demo.service;

import java.util.List;

import com.springBootApp.demo.DTO.NewUserDTO;
import com.springBootApp.demo.DTO.UserDTO;

public interface IUserService {

	public UserDTO retrieveUser(String loginId);
	
	public List<UserDTO> retrieveUsers();
	
	public UserDTO create(NewUserDTO newUserDTO);
}
