package com.codingdojo.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
public class HomeController {
	String name, location, flang, comment;
	
    @RequestMapping("/")
    public String index() {
            return "index.jsp";
    }

    
    @RequestMapping(path="/results", method=RequestMethod.POST)
    public String resultsPost( 
    		@RequestParam(value="name", defaultValue="dname") String name,
    		@RequestParam(value="location", defaultValue="dloc") String location,
    		@RequestParam(value="flang", defaultValue="dlang") String flang,
    		@RequestParam(value="comment", required=false) String comment 
    		) {
		this.name = name;
		this.location = location;
		this.flang = flang;
		this.comment = comment;

            return "redirect:/results";
    }
    
    @RequestMapping(path="/results")
    public String index(Model model) {

            model.addAttribute("name", name);
            model.addAttribute("location", location);
            model.addAttribute("flang", flang);
            model.addAttribute("comment", comment);
            return "results.jsp";
    } 
}
