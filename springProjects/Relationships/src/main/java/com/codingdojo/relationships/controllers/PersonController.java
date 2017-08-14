package com.codingdojo.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.PersonService;

@Controller
public class PersonController {
	///////////// import Services /////////
	
	private final PersonService personService;
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	///////////// import Services /////////
	
	// INDEX PAGE
    @RequestMapping("/")
    public String index() {		
    		return "index.jsp";			
    	}
    
    // PERSON PAGE
    @RequestMapping("/persons/new")
    public String newPerson(
    		@Valid @ModelAttribute("person") Person person,
    		BindingResult result
    		) {		
    		return "person_new.jsp";			
    	}
    @PostMapping("/persons/new")
    public String createPersonPost(
    		Model model,
    			@Valid @ModelAttribute("person") Person person,
    			BindingResult result
    		) {
    		if(result.hasErrors()) {
    			System.out.println("we have errors doing person");
    			return "person_new.jsp";
    		} else {
    			personService.setNewPerson(person);
    			return "redirect:/";
    		}
    	
    }
    
    

   

}
