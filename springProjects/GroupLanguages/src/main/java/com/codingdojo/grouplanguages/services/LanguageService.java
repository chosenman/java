package com.codingdojo.grouplanguages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.codingdojo.grouplanguages.models.*;

@Service
public class LanguageService {

    // initialize the books variable with values
    private List<Language> languages = new ArrayList<Language>(Arrays.asList(
            new Language("Java", "James Gosling", "1.8")
            ));
    
    // returns all the books
    public List<Language> allLangs() {
        return languages;
    }
    
    public Language findLangByIndex(int index) {
        if (index < languages.size()){
            return languages.get(index);
        }else{
            return null;
        }
    }
    
    public void deleteRecord(int index) {
    		languages.remove(index);
    }
    public void setNewLang(Language newLang) {
    	languages.add(newLang);
    }
	
    // from lesson
    public void updateLang(int id, Language lang) {
        if (id < languages.size()){
            languages.set(id, lang);
        }
    }
	
}
