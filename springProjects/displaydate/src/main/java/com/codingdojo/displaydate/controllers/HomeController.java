package com.codingdojo.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model blabla) {
		
		String myCustomobje = "dsdf";
		
		blabla.addAttribute("myCustomNameinTemplate", myCustomobje);
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model blabla) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE 'the' d 'of' MMMM',' y");
		Date now = new Date();

		String dateAsString = sdf.format(now); //"23:27:43 PM"
	
		
		blabla.addAttribute("dateAsString", dateAsString);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model blabla) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a");
		Date now = new Date();

		String dateAsString = sdf.format(now); //"23:27:43 PM"
	
		
		blabla.addAttribute("dateAsString", dateAsString);
		return "date.jsp";
	}
	
	
}
