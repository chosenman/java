package com.codingdojo.auth.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.auth.models.User;
import com.codingdojo.auth.services.UserService;
import com.codingdojo.auth.validator.UserValidator;


@Controller
public class Users {
	
    // NEW
    private UserValidator userValidator;
	//
    private UserService userService;
    public Users(UserService userService, UserValidator userValidator) {
	    this.userService = userService;
	    this.userValidator = userValidator;
    }
	//
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "homePage.jsp";
    }
    
    // REGISTRATION
	    @RequestMapping("/registration")
	    public String registerForm(@Valid @ModelAttribute("user") User user) {
	        return "registrationPage.jsp";
	    }
	    
	    @PostMapping("/registration")
	    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		    
	    		// NEW
	    		userValidator.validate(user, result);
	    		if (result.hasErrors()) {
		        return "registrationPage.jsp";
		    }
	    		
		    userService.saveWithUserRole(user);
		    return "redirect:/login";
	    }
	    
    // LOGIN
	    @RequestMapping("/login")
	    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
	        if(error != null) {
	            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
	        }
	        if(logout != null) {
	            model.addAttribute("logoutMessage", "Logout Successfull!");
	        }
	        return "loginPage.jsp";
	    }
}




