package com.codingdojo.countries.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="languages")
public class Language {

    @Id
    @GeneratedValue
    private Long id;
    
	private String country_code;
	private String language;
	private double percentage;
	private int country_id;

	public String getCountry_code(){
		return country_code;
	}

	public void setCountry_code(String country_code){
		this.country_code=country_code;
	}

	public String getLanguage(){
		return language;
	}

	public void setLanguage(String language){
		this.language=language;
	}

	public double getPercentage(){
		return percentage;
	}

	public void setPercentage(double percentage){
		this.percentage=percentage;
	}

	public int getCountry_id(){
		return country_id;
	}

	public void setCountry_id(int country_id){
		this.country_id=country_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
