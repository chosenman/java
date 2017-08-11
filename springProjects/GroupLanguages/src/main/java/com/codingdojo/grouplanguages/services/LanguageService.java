package com.codingdojo.grouplanguages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.codingdojo.grouplanguages.models.*;
import com.codingdojo.grouplanguages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	// WORKING WITH REPOSITORY
	private LanguageRepository languageRepository;
	
    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }
    
//    @Autowired
//    private CrudRepository<Language, Long> languageRepository;


    // initialize the books variable with values
//    private List<Language> languages = new ArrayList<Language>(Arrays.asList(
//            new Language("Java", "James Gosling", "1.8")
//            ));
    
    // returns all the books
    public List<Language> allLangs() {
//        return languages;
    		  return (List<Language>) languageRepository.findAll();
    }
    
    public void addLanguage(Language language){
    		languageRepository.save(language);
    }
    
    public Language findLangByIndex(Long id) {
            return languageRepository.findOne(id);
    }
    
    public void deleteRecord(Long id) {
    			languageRepository.delete(id);
    }
    public void setNewLang(Language newLang) {
    		languageRepository.save(newLang);
    }
	
    // from lesson
    public void updateLang(Long id, Language lang) {
        if (languageRepository.exists(id)){
            languageRepository.save(lang);
        }
    }
	
}
