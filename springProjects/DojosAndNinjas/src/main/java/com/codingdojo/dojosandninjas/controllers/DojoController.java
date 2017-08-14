package com.codingdojo.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.services.DojoService;



@Controller
public class DojoController {

	///
	private final DojoService dojoService;
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	///
	
	
    @RequestMapping("/")
    public String index() {		
    		return "index.jsp";			
    	}
	
    // DOJO PAGE
    @RequestMapping("/dojos/new")
    public String newDojo(
    		@Valid @ModelAttribute("dojo") Dojo dojo,
    		BindingResult result
    		) {		
    		return "new_dojo.jsp";			
    	}
    @PostMapping("/dojos/new")
    public String createDojoPost(
    		Model model,
    			@Valid @ModelAttribute("dojo") Dojo dojo,
    			BindingResult result
    		) {
    		if(result.hasErrors()) {
    			System.out.println("we have errors doing dojo");
    			return "new_dojo.jsp";
    		} else {
    			dojoService.setNewDojo(dojo);
    			return "redirect:/";
    		}
    	
    }
    
}
