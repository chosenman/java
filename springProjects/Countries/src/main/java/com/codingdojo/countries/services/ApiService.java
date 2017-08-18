package com.codingdojo.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.countries.repositories.CityRepository;
import com.codingdojo.countries.repositories.CountryRepository;
import com.codingdojo.countries.repositories.LanguageRepository;

@Service
public class ApiService {
	
	/////////////////////////////
	// importing all repositories
	private CityRepository cityRepository;
	private CountryRepository countryRepository;
	private LanguageRepository languageRepository;
	
	public ApiService(
			CityRepository cityRepository,
			CountryRepository countryRepository,
			LanguageRepository languageRepository
			) {
		this.cityRepository = cityRepository;
		this.countryRepository = countryRepository;
		this.languageRepository = languageRepository;
	}
	/////////////////////////////
	
	
	/////////////////////////////
	public List<Object[]> findAllCountriesThatSpeakSlovene(){
		return countryRepository.findAllCountriesThatSpeakSlovene();
	}
	public List<Object[]> sedondQuery(){
		return countryRepository.sedondQuery();
	}
	

}
