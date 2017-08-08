package com.codingdojo.jspproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import model.Model;

//import model.*;


@Controller
public class HomeController {
	

	
	@RequestMapping("/")
	public String index(Model blabla) {
		
		String myCustomobje = "dsdf";
		
		blabla.addAttribute("myCustomNameinTemplate", myCustomobje);
		return "myFile.jsp";
	}
}
