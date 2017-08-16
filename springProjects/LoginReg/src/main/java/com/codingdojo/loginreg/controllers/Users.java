package com.codingdojo.loginreg.controllers;


import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.loginreg.models.User;
import com.codingdojo.loginreg.services.UserService;
import com.codingdojo.loginreg.validator.UserValidator;


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
    
    // LOGIN REG TOGETHER
    @RequestMapping("/")
    public String home(
    		Model model,
    		// LOGIN PART
    		@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout,
    		// registerPart
    		@Valid @ModelAttribute("userReg") User userReg, BindingResult result, HttpSession session, 
    		
    		Principal principal
    		) {

    		try { 
    			principal.getName();
    			return "redirect:/dashboard";
    		} catch (Exception e) {  }
    		
        return "loginreg.jsp";
    }
    
    
    // dashboard
	    @RequestMapping("/dashboard")
	    public String dashboard(Principal principal, Model model) {
	        // 1
	        String username = principal.getName();
	        model.addAttribute("currentUser", userService.findByUsername(username));
	        model.addAttribute("lastLogin", new Date());
	        return "dashboard.jsp";
	    }
    
    
    
    // REGISTRATION
	    @PostMapping("/registration")
	    public String registration(
	    		// Login part
	    		@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout,
	    		
	    		@Valid @ModelAttribute("userReg") User userReg, BindingResult result, Model model, HttpSession session
	    		) {
		    
	    		// NEW
	    		userValidator.validate(userReg, result);
	    		if (result.hasErrors()) {
	    			System.out.println("we have error");
		        return "loginreg.jsp";
		    }
	    		
		    userService.saveWithUserRole(userReg);
		    return "redirect:/";
	    }
	    
	    // LOGIN
	    @RequestMapping("/login")
	    public String login(
	    		@Valid @ModelAttribute("userReg") User userReg, BindingResult result, Model model, HttpSession session,
	    		
	    		@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout
	    		) {
		        if(error != null) {
		            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		        }
		        if(logout != null) {
		            model.addAttribute("logoutMessage", "Logout Successfull!");
		        }
	        return "loginreg.jsp";
	    }
	    
}


