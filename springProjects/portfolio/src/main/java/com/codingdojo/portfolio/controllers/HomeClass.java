package com.codingdojo.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeClass {
	@RequestMapping("/")
	public String index() {
		return "forward:/index.html";
	}
	
	@RequestMapping("/me")
	public String me() {
		return "forward:/mePage.html";
	}
	
	@RequestMapping("/projects")
	public String projects() {
		return "forward:/projectsPage.html";
	}

}
