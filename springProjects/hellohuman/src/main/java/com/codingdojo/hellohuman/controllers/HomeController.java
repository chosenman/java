package com.codingdojo.hellohuman.controllers;

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
	 
	
	
    @RequestMapping(path="/")
    public String index(Model model, @RequestParam(value="name", required=false, defaultValue="User") String nameField) {
    			String output = "Hello " + nameField;
            model.addAttribute("output", output);
            return "index.jsp";
    }


}
