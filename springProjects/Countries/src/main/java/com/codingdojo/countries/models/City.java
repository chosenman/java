package com.codingdojo.countries.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class City {

    @Id
    @GeneratedValue
    private Long id;
	
	private String name;
	private String country_code;
	private String district;
	private int population;
	private int country_id;

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getCountry_code(){
		return country_code;
	}

	public void setCountry_code(String country_code){
		this.country_code=country_code;
	}

	public String getDistrict(){
		return district;
	}

	public void setDistrict(String district){
		this.district=district;
	}

	public int getPopulation(){
		return population;
	}

	public void setPopulation(int population){
		this.population=population;
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
