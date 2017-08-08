package com.codingdojo.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class HomeController {
	 
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
    			Integer counter = (Integer) session.getAttribute("counter");
    			if(counter==null) {
    				counter =1;
    			} else {
    	            counter++;			
    			}
            session.setAttribute("counter", counter);
            return "index.jsp";
    }
    @RequestMapping("/counter")
    public String counter(Model model, HttpSession session){
    			Integer counter = (Integer) session.getAttribute("counter");
    			
    			System.out.println(counter);
    			model.addAttribute("counter", counter);
            return "counter.jsp";
    }

}
