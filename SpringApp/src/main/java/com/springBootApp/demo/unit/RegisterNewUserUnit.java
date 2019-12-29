package com.springBootApp.demo.unit;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.springBootApp.demo.DTO.NewUserDTO;
import com.springBootApp.demo.DTO.UserDTO;
import com.springBootApp.demo.model.User;
import com.springBootApp.demo.repository.UserRepository;

@Component
public class RegisterNewUserUnit {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserDTO create(NewUserDTO newUserDTO) {
		User user = userRepository.findByLoginId(newUserDTO.getLoginId());
		UserDTO userDTO = null;

		if (Objects.isNull(user)) {
			System.out.println("User loginId = " + newUserDTO.getLoginId());
			user = new User();
			this.assembleUser(newUserDTO, user);
			userRepository.save(user);
			userDTO = new UserDTO(user);
		}
		return userDTO;
	}

	public void assembleUser(NewUserDTO newUserDTO, User user) {
		user.setLoginId(newUserDTO.getLoginId());
		user.setFirstName(newUserDTO.getFirstName());
		user.setLastName(newUserDTO.getLastName());
		user.setPassword(passwordEncoder.encode(newUserDTO.getPassword()));
		user.setCity(newUserDTO.getPlace());
		user.setRole("USER");
	}
}
