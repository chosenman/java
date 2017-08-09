package com.codingdojo.grouplanguages.controllers;

import java.util.List;

import javax.validation.Valid;

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
public class LanguagesController {
	private final LanguageService languageService;
	
    public LanguagesController(LanguageService languageService){
        this.languageService = languageService;
    }
    
    // NEW LANGUAGE POST
    @PostMapping("/languages/new")
    public String createBook(
    		@RequestParam(value="name", defaultValue="empty") String name,
    		@RequestParam(value="creator", defaultValue="empty") String creator,
    		@RequestParam(value="cver", defaultValue="empty") String cver,
    		Model model,
	    		// from lesson
	    		@Valid @ModelAttribute("lang") Language lang,
	    		BindingResult result
    		) {
		// from lesson
		if (result.hasErrors()) {
			List<Language> languages = languageService.allLangs();
            model.addAttribute("languages", languages);
            return "index.jsp";
		}else{
	    		Language newOne = new Language(name, creator, cver );
	    		if(true) {
	    			languageService.setNewLang(newOne);
	    		}
	    		model.addAttribute("error", "error message");
	    		return "redirect:/languages";
	     }
    	

    }
    
    // SHOW ALL LANGUAGES
    @RequestMapping("/languages")
    public String index(
    		Model model,
    		// from lesson
    		@Valid @ModelAttribute("lang") Language lang,
    		BindingResult result
    		) {
    			List<Language> languages = languageService.allLangs();
            model.addAttribute("languages", languages);
            return "index.jsp";
    }
    
    // One language
    @RequestMapping("/languages/{index}")
    public String findLanguage(Model model, @PathVariable("index") int index) {
    			Language lang = languageService.findLangByIndex(index);
    			if (lang != null) {
	            model.addAttribute("lang", lang);
	            return "showLanguage.jsp";
    			} else {
    				return "redirect:/languages";
    			}
    }
    
    // //////
    // DELETE
    @RequestMapping("/languages/delete/{index}")
    public String deleteLanguage(Model model, @PathVariable("index") int index) {
    			languageService.deleteRecord(index);
    			return "redirect:/languages";
    }
    
    // //////
    // UPDATE GET
    @RequestMapping("/languages/update/{index}")
    public String updateLanguage(Model model, @PathVariable("index") int index) {
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
    		@PathVariable("index") int index,
    		@RequestParam(value="name", defaultValue="empty") String name,
    		@RequestParam(value="creator", defaultValue="empty") String creator,
    		@RequestParam(value="cver", defaultValue="empty") String cver,
    		
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
    	
    		// manual update
//    		Language lang = languageService.findLangByIndex(index);
//    		lang.setName(name);
//    		lang.setCreator(creator);
//    		lang.setCver(cver);
//
//    		model.addAttribute("error", "error message");
//    		return "redirect:/languages";
    }  

}
