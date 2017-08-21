package com.codingdojo.eventsbelt.controllers;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.codingdojo.eventsbelt.models.Comment;
import com.codingdojo.eventsbelt.models.Event;
import com.codingdojo.eventsbelt.models.User;
import com.codingdojo.eventsbelt.services.CommentService;
import com.codingdojo.eventsbelt.services.EventService;
import com.codingdojo.eventsbelt.services.UserService;

@Controller
public class EventsController {

    private UserService userService;	
	private EventService eventService;
	private CommentService commentService;
	public EventsController(EventService eventService, UserService userService, CommentService commentService) {
		this.eventService = eventService;
		this.userService = userService;
		this.commentService = commentService;
	}
	
	
    // events
    @RequestMapping("/events")
    public String dashboard( 
    		Model model, Principal principal,
    		@Valid @ModelAttribute("event") Event event, BindingResult result,
    		@Valid @ModelAttribute("message") Comment message
    		) {

		try { 
			String username = principal.getName();
			User currentUser = userService.findByUsername(username);
			Boolean isAdmin = userService.ifThisUserisAdmin(currentUser.getId());
	        model.addAttribute("currentUser", currentUser );
	        model.addAttribute("isAdmin", isAdmin );
	        
	        List<Event> allEvents = eventService.findAll();
	        model.addAttribute("allEvents", allEvents );
	        model.addAttribute("states", states );
	        return "events.jsp";
		} catch (Exception e) {  return "redirect:/"; }
    	

    }
    
    
    // CREATE NEW EVENT
    @PostMapping("/events/new")
    public String newEvent(
    			Model model, Principal principal,
			@Valid @ModelAttribute("event") Event event,
			BindingResult result,
			@RequestParam(value="myDate", defaultValue="myDate") String myDate,
			@Valid @ModelAttribute("message") Comment message
    		) {
		try { 
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
		} catch (Exception e) {  return "redirect:/"; }

    }
    
    // SHOW ONE EVENT
    @RequestMapping("/events/{event_id}")
    public String showOneEvent( 
    		Model model, Principal principal,
    		@PathVariable("event_id") Long event_id,
    		@Valid @ModelAttribute("message_model") Comment message_model, BindingResult result,
    		@Valid @ModelAttribute("message") Comment message
    		) {
		try { 
    			String username = principal.getName();
    			User currentUser = userService.findByUsername(username);
    			Event currentEvent = eventService.findById(event_id);
    			Boolean isAdmin = userService.ifThisUserisAdmin(currentUser.getId());
    	        model.addAttribute("currentUser", currentUser );
    	        model.addAttribute("isAdmin", isAdmin );
    	        model.addAttribute("currentEvent", currentEvent );
    	        // form deatils
    	        model.addAttribute("user_id", currentUser.getId() );
    	        model.addAttribute("event_id", event_id );
    	        ArrayList <Comment> messages = (ArrayList<Comment>) commentService.findByEventId(event_id);
//    	        List<Comment> messages = commentService.findAll();
    	        model.addAttribute("messages", messages);
    	        
    	        return "one_event.jsp";
		} catch (Exception e) {  return "redirect:/"; }
    }
    
    // JOIN EVENT
    @RequestMapping("/events/{event_id}/join")
    public String join( 
    		Model model, Principal principal,
    		@PathVariable("event_id") Long event_id
    		) {
    		
		try { 
	    		String username = principal.getName();
	    		User currentUser = userService.findByUsername(username);
	    		userService.joinEvent(event_id, currentUser.getId());
	    		
	    		return "redirect:/events";	
		} catch (Exception e) {  return "redirect:/"; }
    }
    
    // CANCEL join EVENT
    @RequestMapping("/events/{event_id}/cancel")
    public String cancel( 
    		Model model, Principal principal,
    		@PathVariable("event_id") Long event_id,
    		@Valid @ModelAttribute("message") Comment message
    		) {
    		
		try { 
	    		String username = principal.getName();
	    		User currentUser = userService.findByUsername(username);
	    		userService.cancelJoinEvent(event_id, currentUser.getId());
	    		
	    		return "redirect:/events";	
		} catch (Exception e) {  return "redirect:/"; }
    }
    
    // DELETE EVENT
    @RequestMapping("/events/{event_id}/delete")
    public String delete( 
    		Model model,
    		@PathVariable("event_id") Long event_id,
    		@Valid @ModelAttribute("message") Comment message
    		) {
		try { 
//	    		String username = principal.getName();
//	    		User currentUser = userService.findByUsername(username);
	    		eventService.deleteEvent(event_id);
	    		return "redirect:/events";	
		} catch (Exception e) {  return "redirect:/"; }
    }
    
    // EDIT EVENT
    @RequestMapping("/events/{event_id}/edit")
    public String edit( 
    		Model model, Principal principal,
    		@PathVariable("event_id") Long event_id,
    		@Valid @ModelAttribute("message") Comment message
    		) {

			String username = principal.getName();
			User currentUser = userService.findByUsername(username);
			model.addAttribute("currentUser", currentUser );
	        model.addAttribute("states", states );
    			Event event = eventService.findById(event_id);
			model.addAttribute("dateString", stringFromString(event.getEventDate()) );
    			model.addAttribute("event", event);
//    			return "redirect:/events";	
    		return "edit_event.jsp";	
    }
		    // EDIT EVENT POST
		    @PostMapping("/events/{event_id}/edit")
		    public String editPost( 
		    		Model model, Principal principal,
		    		@PathVariable("event_id") Long event_id,
		    		@Valid @ModelAttribute("message") Comment message,
		    		@RequestParam(value="myDate", defaultValue="myDate") String myDate,
		    		@Valid @ModelAttribute("event") Event event, BindingResult result
		    		) {
		    		
		    		event.setEventDate(dateFromString(myDate));
		    	
				if(result.hasErrors()) {
					System.out.println("we have errors doing event");
					return "edit_event.jsp";
				} else {
			    		eventService.editEvent(event, event_id);
		    		return "redirect:/events";	
				}
		    }
    
    // POST MASSAGE
    @PostMapping("/message/new")
    public String newMessage(
    			Model model, Principal principal,
    			@RequestParam(value="event_id", defaultValue="") Long event_id,
    			@RequestParam(value="user_id", defaultValue="") Long user_id,
			@Valid @ModelAttribute("message_model") Comment message_model,
			@Valid @ModelAttribute("message") Comment message,
			BindingResult result
    		) {
    		System.out.println(event_id);
    		System.out.println(user_id);
    		
    		User author = userService.findById(user_id);
    		Event event = eventService.findById(event_id);
    		
    		message_model.setAuthor(author);
    		message_model.setWhich_event(event);
    	

    		
    		if(result.hasErrors()) {
    			System.out.println("we have errors doing event");
    			return "redirect:/events/"+event_id;	
    		} else {
    	    		commentService.setNewMessage(message_model);
        		return "redirect:/events/"+event_id;	
    		}

    }
	
	
// //////////////////
//    HELPER FUNCTION AND DATA
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
	
	public String stringFromString(Date Date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 2019-08-09
		String result = null;
		try {
			result = sdf.format(Date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("oops");
		}
		
		return result;
		}
    
	String[] states = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY" };
    
}
