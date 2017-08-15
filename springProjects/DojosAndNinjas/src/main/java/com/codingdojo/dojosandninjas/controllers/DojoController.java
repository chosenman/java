package com.codingdojo.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.services.DojoService;
import com.codingdojo.dojosandninjas.services.NinjaService;



@Controller
public class DojoController {

	///
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	public DojoController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	///
	
	
    @RequestMapping("/")
    public String index(Model model) {		
    		model.addAttribute("dojos", dojoService.findAllDojo());
    		return "index.jsp";			
    	}
	
    // ONE DOJO
    @RequestMapping("/dojos/{id}")
    public String OneDojo(
    		@PathVariable("id") Long id,
    		Model model
    		) {		
	    	model.addAttribute("dojo", dojoService.findOne(id));
	    	model.addAttribute("ninjas", ninjaService.findAllNinjas() );
    		return "one_dojo.jsp";			
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
