package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.countries.models.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

	
	
	// 1.  What query would you run to get all the countries that speak Slovene? Your query should return the name of the country, language and language percentage. Your query should arrange the result by language percentage in descending order.
    
    @Query(value="SELECT countries.name, languages.language, languages.percentage\n" + 
    		"FROM countries\n" + 
    		"JOIN languages\n" + 
    		"ON languages.country_id = countries.id\n" + 
    		"WHERE language = \"Slovene\"\n" + 
    		"ORDER BY percentage DESC", nativeQuery=true)
    List<Object[]> findAllCountriesThatSpeakSlovene();
    
    
    // 2.  What query would you run to display the total number of cities for each country? Your query should return the name of the country and the total number of cities. Your query should arrange the result by the number of cities in descending order.
    @Query(value="SELECT countries.name, COUNT(cities.name)\n" + 
    		"FROM countries\n" + 
    		"left JOIN cities\n" + 
    		"ON countries.code = cities.country_code\n" + 
    		"group by countries.name\n" + 
    		"ORDER BY COUNT(cities.name) DESC", nativeQuery=true)
    List<Object[]> sedondQuery();
    
    // 3.  What query would you run to get all the cities in Mexico with a population of greater than 500,000? Your query should arrange the result by population in descending order.
    @Query(value="SELECT cities.name, cities.population\n" + 
    		"FROM cities \n" + 
    		"JOIN countries \n" + 
    		"ON countries.id = cities.country_id\n" + 
    		"WHERE cities.population > 500000 AND countries.name = \"Mexico\"", nativeQuery=true)
    List<Object[]> q3();
    
    // 4. What query would you run to get all languages in each country with a percentage greater than 89%? Your query should arrange the result by percentage in descending order.
    @Query(value="SELECT countries.name, languages.language, languages.percentage\n" + 
    		"FROM languages\n" + 
    		"LEFT JOIN countries\n" + 
    		"ON countries.id = languages.country_id\n" + 
    		"WHERE languages.percentage > 89\n" + 
    		"ORDER BY languages.percentage DESC", nativeQuery=true)
    List<Object[]> q4();
    
    // 5. What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?
    @Query(value="SELECT countries.name, countries.surface_area, countries.population\n" + 
    		"FROM countries\n" + 
    		"WHERE countries.surface_area < 501 AND countries.population > 100000", nativeQuery=true)
    List<Object[]> q5();
    
    // 6. What query would you run to get countries with only Constitutional Monarchy with a capital greater than 200 and a life expectancy greater than 75 years?
    @Query(value="SELECT countries.name, countries.government_form, countries.capital, countries.life_expectancy\n" + 
    		"FROM countries\n" + 
    		"JOIN cities\n" + 
    		"ON countries.capital = cities.id\n" + 
    		"WHERE countries.government_form = \"Constitutional Monarchy\" AND countries.capital > 200 AND countries.life_expectancy", nativeQuery=true)
    List<Object[]> q6();
    
    // 7. What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? The query should return the Country Name, City Name, District and Population.
    @Query(value="SELECT countries.name as c_name, cities.name, cities.district, cities.population\n" + 
    		"FROM countries\n" + 
    		"JOIN cities\n" + 
    		"ON countries.id = cities.country_id\n" + 
    		"WHERE cities.district = \"Buenos Aires\" AND cities.population > 500000", nativeQuery=true)
    List<Object[]> q7();
    
    // 8. What query would you run to summarize the number of countries in each region? The query should display the name of the region and the number of countries. Also, the query should arrange the result by the number of countries in descending order.
    @Query(value="SELECT countries.region, COUNT(countries.name) as countries\n" + 
    		"FROM countries\n" + 
    		"GROUP BY countries.region\n" + 
    		"ORDER BY COUNT(countries.name) DESC", nativeQuery=true)
    List<Object[]> q8();
    
}
