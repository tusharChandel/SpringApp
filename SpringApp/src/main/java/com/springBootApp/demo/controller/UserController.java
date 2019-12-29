package com.springBootApp.demo.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springBootApp.demo.DTO.NewUserDTO;
import com.springBootApp.demo.DTO.UserDTO;
import com.springBootApp.demo.exception.LoginIdAlreadyRegisteredException;
import com.springBootApp.demo.exception.UserLoginIdNotFoundException;
import com.springBootApp.demo.response.handler.ApiBaseController;
import com.springBootApp.demo.service.IUserService;

@Controller
@Validated
@RequestMapping("/api")
public class UserController extends ApiBaseController {

	@Autowired
	private IUserService userService;

	@GetMapping
	public String home() {
		return "index.jsp";
	}

	@GetMapping(value = "/users")
	@ResponseBody
	public ResponseEntity<List<UserDTO>> getUsers() {

		List<UserDTO> userDTOs = userService.retrieveUsers();
		if (CollectionUtils.isEmpty(userDTOs)) {
			throw new UserLoginIdNotFoundException("No users found.");
		} else {
			return new ResponseEntity<List<UserDTO>>(userDTOs, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/user/{loginId}")
	@ResponseBody
	public ResponseEntity<UserDTO> getUser(
			@PathVariable("loginId") @NotBlank @Size(min = 2) @Pattern(regexp = "[A-Za-z]{1,5}") String loginId)
			throws UserLoginIdNotFoundException {

		UserDTO userDTO = userService.retrieveUser(loginId);
		if (Objects.isNull(userDTO)) {
			System.out.println("User Name not found.");
			throw new UserLoginIdNotFoundException(loginId + " not found.");
		} else {
			System.out.println(userDTO.getFirstName());
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/createUser", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_FORM_URLENCODED_VALUE }, produces = { MediaType.APPLICATION_ATOM_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody NewUserDTO newUserDTO) {
		System.out.println("Got into Registration");

		UserDTO userDTO = userService.create(newUserDTO);
		if (Objects.isNull(userDTO)) {
			throw new LoginIdAlreadyRegisteredException(newUserDTO.getLoginId() + " is already registred.");
		} else {
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
		}
	}
}