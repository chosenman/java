package com.codingdojo.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	// score
	Integer score;
	ArrayList<String> log = new ArrayList<String>();
	
    @RequestMapping("/")
    public String index(Model model) {
    	
    // if this is new game:
    	if(score == null) { score = 0; }
    	
    	model.addAttribute("score", score);
    return "index.jsp";
    }
    
    @RequestMapping(path="/process_money", method=RequestMethod.POST)
    public String resultsPost( 
    		@RequestParam(value="activity", defaultValue="empty") String activity
    		) {
    		// if pushed farm
    		if(activity.equals("farm")) {
    			this.score += randomWithRange(10, 20);
    		// if pushed cave
    		} else if(activity.equals("cave")) {
    			this.score += randomWithRange(5, 10);
        	// if pushed house
    		} else if(activity.equals("house")) {
    			this.score += randomWithRange(2, 5);
        	// if pushed casino
    		}else if(activity.equals("casino")) {
    			this.score += randomWithRange(-50, 50);
    		// if pushed reset
	    }else if(activity.equals("reset")) {
	    		this.score=0;
	    }
    			System.out.println(activity);

            return "redirect:/";
    }
    
    public String message(int result, String place) {
    		String output = null;
    		SimpleDateFormat sdf = new SimpleDateFormat("EEEE 'the' d 'of' MMMM',' y HH:mm:ss a");
    		Date now = new Date();
    		String dateAsString = sdf.format(now);
    		
    		if(result>0) {
    			// positive message
    			output += "You entered a " + place + " and earned " + result + " gold   (" + dateAsString + ")";
    		} else {
    			// negative message
    			output += "You entered a " + place + " and lost " + result + " gold  Ouch.. (" + dateAsString + ")";
    		}
    		
    		return output;
    }
    
    public int randomWithRange(int min, int max){
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

}
