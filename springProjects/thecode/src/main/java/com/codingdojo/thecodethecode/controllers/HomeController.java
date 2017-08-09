package com.codingdojo.thecodethecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String index(
			Model model,
			@ModelAttribute("errors") String errors
			) {
		
		model.addAttribute("errorMSG", errors);
		System.out.println(errors);
		return "index.jsp";
	}
	
    @RequestMapping(path="/code", method=RequestMethod.POST)
    public String codePOST(
    		RedirectAttributes redirectAttributes,
    		@RequestParam(value="codeInput", defaultValue="") String codeInput
    		){
    		if( codeInput.equals("bushido") ) {
    			return "code.jsp";
    		}
    		
        redirectAttributes.addFlashAttribute("errors", "YOU MUST TRAIN HARDER!");
        return "redirect:/";
    }
    
    @RequestMapping(path="/code")
    public String codeGet(){

        return "redirect:/";
    }
	
    @RequestMapping("/errors")
    public String errors(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("errors", "A test errror!");
        return "redirect:/";
    }
    
}
