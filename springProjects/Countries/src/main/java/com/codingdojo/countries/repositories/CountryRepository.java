package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.countries.models.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

	
	
	// What query would you run to get all the countries that speak Slovene? Your query should return the name of the country, language and language percentage. Your query should arrange the result by language percentage in descending order.
    
    @Query(value="SELECT countries.name, languages.language, languages.percentage\n" + 
    		"FROM countries\n" + 
    		"JOIN languages\n" + 
    		"ON languages.country_id = countries.id\n" + 
    		"WHERE language = \"Slovene\"\n" + 
    		"ORDER BY percentage DESC", nativeQuery=true)
    List<Object[]> findAllCountriesThatSpeakSlovene();
    
    
    // What query would you run to display the total number of cities for each country? Your query should return the name of the country and the total number of cities. Your query should arrange the result by the number of cities in descending order.
    @Query(value="SELECT countries.name, COUNT(cities.name)\n" + 
    		"FROM countries\n" + 
    		"left JOIN cities\n" + 
    		"ON countries.code = cities.country_code\n" + 
    		"group by countries.name\n" + 
    		"ORDER BY COUNT(cities.name) DESC", nativeQuery=true)
    List<Object[]> sedondQuery();
    
    
}
