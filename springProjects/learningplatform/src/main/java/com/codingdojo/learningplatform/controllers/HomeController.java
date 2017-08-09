package com.codingdojo.learningplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
    @RequestMapping("/m/{chapter}/0483/{assignmentNumber}")
    public String showProduct(
    		Model model,
    		@PathVariable("chapter") String chapter,
    		@PathVariable("assignmentNumber") String assignmentNumber
    		){
    		
		if(chapter.equals("38")) {
			if(assignmentNumber.equals("0345")) {
				System.out.println("we hit 0345");
				model.addAttribute("message", "Coding Forms");
				return "assignment.jsp";
			}
		} else if(chapter.equals("26")) {
			if(assignmentNumber.equals("2342")) {
				System.out.println("we hit 2342");
				model.addAttribute("message", "Fortran to Binary");
				return "assignment.jsp";
			}
		}
    		
//    		switch(url) {
//    			case "38/0553/0733":
//    				model.addAttribute("message", "Setting up your servers");
//    				return "lesson.jsp";
//    			default:
//    				break;
//    		}

    		return "index.jsp";
    }
    
    
    @RequestMapping("/m/{chapter}/0553/{assignmentNumber}")
    public String oneMore(
    		Model model,
    		@PathVariable("chapter") String chapter,
    		@PathVariable("assignmentNumber") String assignmentNumber
    		){
		if(chapter.equals("38")) {
			if(assignmentNumber.equals("0733")) {
				System.out.println("we hit 0733");
				model.addAttribute("message", "Setting up your servers");
				return "lesson.jsp";
			} else if( assignmentNumber.equals("0342") ) {
				System.out.println("we hit 0342");
				model.addAttribute("message", "	Punch Cards");
				return "lesson.jsp";
			}
		} else if(chapter.equals("26")) {
			if(assignmentNumber.equals("0348")) {
				System.out.println("we hit 0348");
				model.addAttribute("message", "Advanced Fortran Intro");
				return "lesson.jsp";
			}
		}
		return "index.jsp";
    }
    
}
