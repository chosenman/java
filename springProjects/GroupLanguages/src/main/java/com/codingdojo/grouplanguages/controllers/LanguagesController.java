package com.codingdojo.grouplanguages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.grouplanguages.models.*;
import com.codingdojo.grouplanguages.services.LanguageService;

@Controller
//@EntityScan(basePackageClasses=Language.class)
public class LanguagesController {
	
	private final LanguageService languageService;
	
    public LanguagesController(LanguageService languageService){
        this.languageService = languageService;
    }
    
    // NEW LANGUAGE POST
    @PostMapping("/languages/new")
    public String createBook(
    		Model model,
	    		@Valid @ModelAttribute("lang") Language lang,
	    		BindingResult result
    		) {
		if (result.hasErrors()) {
			List<Language> languages = languageService.allLangs();
            model.addAttribute("languages", languages);
            return "index.jsp";
		}else{
	    		languageService.setNewLang(lang);
	    		model.addAttribute("error", "error message");
	    		return "redirect:/languages";
	     }
    	

    }
    
    // SHOW ALL LANGUAGES
    @RequestMapping("/languages")
    public String index(
    		Model model,
    		@Valid @ModelAttribute("lang") Language lang,
    		BindingResult result
    		) {
    			List<Language> languages = languageService.allLangs();
            model.addAttribute("languages", languages);
            return "index.jsp";
    }
    
    // One language
    @RequestMapping("/languages/{id}")
    public String findLanguage(Model model, @PathVariable("id") Long id) {
    			Language lang = languageService.findLangByIndex(id);
    			if (lang != null) {
	            model.addAttribute("lang", lang);
	            return "showLanguage.jsp";
    			} else {
    				return "redirect:/languages";
    			}
    }
    
    // //////
    // DELETE
    @RequestMapping("/languages/delete/{id}")
    public String deleteLanguage(Model model, @PathVariable("id") Long id) {
    			languageService.deleteRecord(id);
    			return "redirect:/languages";
    }
    
    // //////
    // UPDATE GET
    @RequestMapping("/languages/update/{index}")
    public String updateLanguage(Model model, @PathVariable("index") Long index) {
    			Language lang = languageService.findLangByIndex(index);
    			if (lang != null) {
    	            model.addAttribute("lang", lang);
    	            model.addAttribute("index", index);
    	            return "updateLanguage.jsp";
    			} else {
    				return "redirect:/languages";
    			}
    }
    // UPDATE POST
    @PostMapping("/languages/update/{index}")
    public String updateLanguagePOST(
    			@PathVariable("index") Long index,
    		
	    		// from lesson
	    		@Valid @ModelAttribute("lang") Language lang,
	    		BindingResult result,
	    		
    		Model model
    		) {
    	
    			// from lesson
	    		if (result.hasErrors()) {
	    			return "updateLanguage.jsp";
	    		}else{
	    			languageService.updateLang(index, lang);
	            return "redirect:/languages";
	         }
    	
    }  

}
