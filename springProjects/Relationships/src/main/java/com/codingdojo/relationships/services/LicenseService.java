package com.codingdojo.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.*;
import com.codingdojo.relationships.repositories.LicenseRepository;
import com.codingdojo.relationships.repositories.PersonRepository;


@Service
public class LicenseService {
	
	private LicenseRepository licenseRepository;
	private PersonRepository personRepository;
	public LicenseService(LicenseRepository licenseRepository, PersonRepository personRepository) {
		this.licenseRepository = licenseRepository;
		this.personRepository = personRepository;
	}
	
	public List<Person> findAllpersonsWithoutLIcense(){
		return (List<Person>) personRepository.findAllByLicenseNull();
	}
	
	public void setNewPerson(License license) {
		licenseRepository.save(license);
	}
	

}
