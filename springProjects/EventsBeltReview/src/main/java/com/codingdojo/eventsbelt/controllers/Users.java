package com.codingdojo.eventsbelt.controllers;


import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.eventsbelt.models.User;
import com.codingdojo.eventsbelt.services.UserService;
import com.codingdojo.eventsbelt.validator.UserValidator;


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
    		@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, 
    		
    		Principal principal
    		) {

//    		System.out.println( userService.findAnyAdminRole().size() == 0 );
    	
    		try { 
    			principal.getName();
    			return "redirect:/events";
    		} catch (Exception e) {  }
    		
    		model.addAttribute("states", states );
        return "loginreg.jsp";
    }
    
    // admin dashboard
	    @RequestMapping("/admin")
	    public String adminDashboard(Principal principal, Model model) {
	
	    		try { 
	    			
	    			String username = principal.getName();
	    			User currentUser = userService.findByUsername(username);
	    	        model.addAttribute("currentUser", currentUser );
	    	        model.addAttribute("lastLogin", new Date());
	    	        
	    	        // if user from Admins do this
	    	        Boolean isAdmin = userService.ifThisUserisAdmin(currentUser.getId());
	    	        if( isAdmin ) {
	    	        		model.addAttribute("adminRole", userService.findAdmin());
	    	        		model.addAttribute("allUsers", userService.findAll());
	    	        }
	    	        
	    	        model.addAttribute("isAdmin", isAdmin );
	    	        return "admin.jsp";
	
	    		} catch (Exception e) {  }
	    		
	    		return "redirect:/";
	    }
	    
	    // DELETE USER
	    @RequestMapping("/admin/delete/{user_id}")
	    public String delete(
	    		@PathVariable("user_id") Long user_id
	    		) {
		    	try { 
			    userService.delete(user_id);
		    	} catch (Exception e) {  }

		    return "redirect:/admin";
	    }
	    // MAKE ADMIN
	    @RequestMapping("/admin/make_admin/{user_id}")
	    public String make_admin(
	    		@PathVariable("user_id") Long user_id
	    		) {
		    	try { 
		    		User user = userService.findById(user_id);
		    		userService.saveUserWithAdminRole(user);
		    	} catch (Exception e) {  }

		    return "redirect:/admin";
	    }
	    
	    
    
   
    
    
    
    // REGISTRATION
	    @PostMapping("/registration")
	    public String registration(
	    		// Login part
	    		@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout,
	    		
	    		@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session
	    		) {
		    
	    		// NEW
	    		userValidator.validate(user, result);
	    		if (result.hasErrors()) {
	    			System.out.println("we have error");
		        return "loginreg.jsp";
		    }
	    		
	    		if( userService.findAnyAdminRole().size() == 0 ) {
	    			userService.saveUserWithAdminRole(user);
	    		} else {
	    		    userService.saveWithUserRole(user);
	    		}

		    return "redirect:/";
	    }
	    
	    // LOGIN
	    @RequestMapping("/login")
	    public String login(
	    		@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session,
	    		
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
	    
		String[] states = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY" };
		 
	    
}


