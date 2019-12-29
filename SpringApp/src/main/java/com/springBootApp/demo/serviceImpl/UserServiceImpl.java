package com.springBootApp.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootApp.demo.DTO.NewUserDTO;
import com.springBootApp.demo.DTO.UserDTO;
import com.springBootApp.demo.service.IUserService;
import com.springBootApp.demo.unit.RegisterNewUserUnit;
import com.springBootApp.demo.unit.RetrieveUsersUnit;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private RetrieveUsersUnit retrieveUsersUnit;
	
	@Autowired
	private RegisterNewUserUnit registerNewUserUnit;
	
	@Override
	public UserDTO retrieveUser(String loginId) {
		return retrieveUsersUnit.retrieveUser(loginId);
	}
	
	@Override
	public List<UserDTO> retrieveUsers() {
		return retrieveUsersUnit.retrieveUsers();
	}

	@Override
	public UserDTO create(NewUserDTO newUserDTO) {
		return registerNewUserUnit.create(newUserDTO);
	}

}
