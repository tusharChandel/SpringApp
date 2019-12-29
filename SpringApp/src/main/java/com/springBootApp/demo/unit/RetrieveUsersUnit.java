package com.springBootApp.demo.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.springBootApp.demo.DTO.UserDTO;
import com.springBootApp.demo.model.User;
import com.springBootApp.demo.repository.UserRepository;

@Component
public class RetrieveUsersUnit {

	@Autowired
	private UserRepository userRepository;

	public UserDTO retrieveUser(String loginId) {

		UserDTO userDTO = null;
		User user = userRepository.findByLoginId(loginId);
		if (Objects.isNull(user)) {
			System.out.println("User is not found");
		} else {
			userDTO = new UserDTO();
			this.assembler(user, userDTO);
		}
		return userDTO;
	}

	public List<UserDTO> retrieveUsers() {

		List<UserDTO> userDTOs = null;

		List<User> users = userRepository.findAll();
		if (!CollectionUtils.isEmpty(users)) {
			userDTOs = new ArrayList<UserDTO>();
			this.assembler(users, userDTOs);
			if (CollectionUtils.isEmpty(userDTOs)) {
				System.out.println("\n Still Empty");
			}
		}
		return userDTOs;
	}

	public void assembler(List<User> users, List<UserDTO> userDTOs) {
		for (User user : users) {
			UserDTO userDTO = new UserDTO(user);
			this.assembler(user, userDTO);
			System.out.println(
					user.getLoginId() + "," + user.getCity() + "," + user.getFirstName() + "," + user.getLastName());
			// System.out.println("List size = "+userDTOs.size());
			userDTOs.add(userDTO);
			System.out.println(userDTO.getLoginId() + "," + userDTO.getCity() + "," + userDTO.getFirstName() + ","
					+ userDTO.getLastName());

			System.out.println("List size = " + userDTOs.size());
		}
	}

	public void assembler(User user, UserDTO userDTO) {
		userDTO.setLoginId(user.getLoginId());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setCity(user.getCity());
	}
}
