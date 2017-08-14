package com.codingdojo.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.DojoService;
import com.codingdojo.dojosandninjas.services.NinjaService;


@Controller
public class NinjaController {

	///
	private final NinjaService ninjaService;
	public NinjaController(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}
	///
	
	
	
	
	
	
	
    // DOJO PAGE
    @RequestMapping("/ninjas/new")
    public String newNinja(
    		Model model,
    		@Valid @ModelAttribute("ninja") Ninja ninja,
    		BindingResult result
    		) {		
    	
    		List<Dojo> dojos = ninjaService.findAllDojos();
    	
    		model.addAttribute("dojos", dojos);
    		return "new_ninja.jsp";			
    	}
    @PostMapping("/ninjas/new")
    public String createNinjaPost(
    		Model model,
    			@Valid @ModelAttribute("ninja") Ninja ninja,
    			BindingResult result
    		) {
    		if(result.hasErrors()) {
    			System.out.println("we have errors doing Ninja");
    			return "new_ninja.jsp";
    		} else {
    			ninjaService.setNewNinja(ninja);
    			return "redirect:/";
    		}
    	
    }
    
    
    
}
