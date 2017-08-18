package com.codingdojo.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.countries.services.ApiService;

@Controller
public class MainController {
	
	// 
	private ApiService apiService;
	public MainController( ApiService apiService ) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/")
	public String root(
			Model model 
			) {
		List <Object[]> sloveneSpeakingC = apiService.findAllCountriesThatSpeakSlovene();
		model.addAttribute("sloveneSpeakingC", sloveneSpeakingC);
		
		List <Object[]> sedondQuery = apiService.sedondQuery();
		model.addAttribute("sedondQuery", sedondQuery);
		return "index.jsp";
	}
	
}
