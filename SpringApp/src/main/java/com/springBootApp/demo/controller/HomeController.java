package com.springBootApp.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController implements ErrorController {

	private static final String PATH = "/error";

	@GetMapping(value = PATH)
	public String error() {
		return "Error handling";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}

	@GetMapping("/login")
	public String login() {
		System.out.println("Got Into Login");
		return "login.jsp";
	}
	
	@GetMapping("/newUser")
	public String register() {
		System.out.println("Got Into New User View");
		return "newUser.jsp";
	}

	@GetMapping("/logout-success")
	public String logout() {
		return "home.jsp";
	}

}
