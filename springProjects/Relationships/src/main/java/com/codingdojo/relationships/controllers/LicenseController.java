package com.codingdojo.relationships.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseService;
import com.codingdojo.relationships.services.PersonService;

@Controller
public class LicenseController {
	private int currentNumber = 1;
	private int numZeros;
	private String newNumber;
	// import service
//	private final PersonService personService;
	
	private final LicenseService licenseService;
	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
    // LICENSE PAGE
    @RequestMapping("/licenses/new")
    public String newLicense(
    		Model model,
    		@Valid @ModelAttribute("license") License license,
    		BindingResult result
    		) {
    		List<Person> persons = licenseService.findAllpersonsWithoutLIcense();
    		newNumber = this.newNumber();

    		license.setNumber(newNumber);
    		currentNumber++;
    		model.addAttribute("allpersons", persons);
    		return "license_new.jsp";			
    	}
    
    @PostMapping("/licenses/new")
    public String createLicensePost(
    		Model model,
    			@Valid @ModelAttribute("license") License license,
    			BindingResult result,
    			@RequestParam(value="myDate", defaultValue="myDate") String myDate
    		) {

    		System.out.println(myDate);
    		license.setExpiration_date( dateFromString(myDate));
    		
    		if(result.hasErrors()) {
    			System.out.println("we have errors doing person");
    			return "license_new.jsp";
    		} else {
    			
    			licenseService.setNewPerson(license);
    			return "redirect:/";
    		}
    	
    }
	
    
    public String newNumber() {
    		// 000000 - 6 zeros
    		String output = "";
    		numZeros = (6 - Integer.toString(currentNumber).length());
    		for(int i=0; i<numZeros; i++) {
    			output += "0";
    		}
    			output += Integer.toString(currentNumber);
    		return output;
    }
    
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
