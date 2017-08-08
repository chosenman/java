package com.codingdojo.sessionlesson.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("sessionAttribute")
public class HomeController {

    @ModelAttribute("sessionAttribute")
    public String getSessionAttribute(){
            return "exampleDefaultData";
    }
//	

    @RequestMapping("/")
    public String index(@ModelAttribute("sessionAttribute") String sessionAttribute, Model model) {
//            sessionAttribute = (String) session.getAttribute("sessionAttribute");
            
            System.out.println(sessionAttribute);
            
            model.addAttribute("blabla", sessionAttribute);
            return "index.jsp";
    }
    @RequestMapping("/setSession")
    public String setSession(@ModelAttribute("sessionAttribute") String sessionAttribute){
//    			String exampleData = "bla bla date";
//    			System.out.println(exampleData);
//            session.setAttribute("sessionAttribute", "bla bla date");
    			sessionAttribute = "bla bla from set";
            return "redirect:/";
    }
	
}
