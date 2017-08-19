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
		
		List <Object[]> q3 = apiService.q3();
		model.addAttribute("q3", q3);
//		
		List <Object[]> q4 = apiService.q4();
		model.addAttribute("q4", q4);
//		
		List <Object[]> q5 = apiService.q5();
		model.addAttribute("q5", q5);
//		
		List <Object[]> q6 = apiService.q6();
		model.addAttribute("q6", q6);
//		
		List <Object[]> q7 = apiService.q7();
		model.addAttribute("q7", q7);
//		
		List <Object[]> q8 = apiService.q8();
		model.addAttribute("q8", q8);
		return "index.jsp";
	}
	
}
