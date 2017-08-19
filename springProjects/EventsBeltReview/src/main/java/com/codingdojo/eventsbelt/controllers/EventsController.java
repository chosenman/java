package com.codingdojo.eventsbelt.controllers;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.eventsbelt.models.Event;
import com.codingdojo.eventsbelt.models.Message;
import com.codingdojo.eventsbelt.models.User;
import com.codingdojo.eventsbelt.services.EventService;
import com.codingdojo.eventsbelt.services.UserService;

@Controller
public class EventsController {

    private UserService userService;	
	private EventService eventService;
	public EventsController(EventService eventService, UserService userService) {
		this.eventService = eventService;
		this.userService = userService;
	}
	
	
    // events
    @RequestMapping("/events")
    public String dashboard( 
    		Model model, Principal principal,
    		@Valid @ModelAttribute("event") Event event, BindingResult result
    		) {

    			String username = principal.getName();
    			User currentUser = userService.findByUsername(username);
    			Boolean isAdmin = userService.ifThisUserisAdmin(currentUser.getId());
    	        model.addAttribute("currentUser", currentUser );
    	        model.addAttribute("isAdmin", isAdmin );
    	        
    	        List<Event> allEvents = eventService.findAll();
    	        model.addAttribute("allEvents", allEvents );
    	        return "events.jsp";
    }
    
    
    // CREATE NEW EVENT
    @PostMapping("/events/new")
    public String newEvent(
    			Model model, Principal principal,
			@Valid @ModelAttribute("event") Event event,
			BindingResult result,
			@RequestParam(value="myDate", defaultValue="myDate") String myDate
    		) {
    		System.out.println(myDate);
    		event.setEventDate(dateFromString(myDate));
    		
   		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
    		event.setHost(currentUser);
    		
    		if(result.hasErrors()) {
    			System.out.println("we have errors doing event");
    			return "events.jsp";
    		} else {
    	    		eventService.setNewEvent(event);
        		return "redirect:/events";	
    		}

    }
    
    // SHOW ONE EVENT
    @RequestMapping("/events/{event_id}")
    public String showOneEvent( 
    		Model model, Principal principal,
    		@PathVariable("event_id") Long event_id,
    		@Valid @ModelAttribute("message") Message message, BindingResult result
    		) {

    			String username = principal.getName();
    			User currentUser = userService.findByUsername(username);
    			Event currentEvent = eventService.findById(event_id);
    			Boolean isAdmin = userService.ifThisUserisAdmin(currentUser.getId());
    	        model.addAttribute("currentUser", currentUser );
    	        model.addAttribute("isAdmin", isAdmin );
    	        model.addAttribute("currentEvent", currentEvent );
    	        
    	        return "one_event.jsp";
    }
    
    // POST MASSAGE
    @PostMapping("/message/new")
    public String newMessage(
    			Model model, Principal principal,
			@Valid @ModelAttribute("event") Event event,
			BindingResult result,
			@RequestParam(value="myDate", defaultValue="myDate") String myDate
    		) {
    		System.out.println(myDate);
    		event.setEventDate(dateFromString(myDate));
    		
   		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
    		event.setHost(currentUser);
    		
    		if(result.hasErrors()) {
    			System.out.println("we have errors doing event");
    			return "events.jsp";
    		} else {
    	    		eventService.setNewEvent(event);
        		return "redirect:/events";	
    		}

    }
	
	
// //////////////////
//    HELPER FUNCTION
	public Date dateFromString(String stringDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 2019-08-09
		Date dateFromString = null;
		try {
			dateFromString = sdf.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dateFromString;
		}
    
    
    
}
