package com.codingdojo.relationships.services;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	
		private PersonRepository personRepository;
		public PersonService(PersonRepository personRepository) {
			this.personRepository = personRepository;
		}
		
		
		
	public void setNewPerson(Person person) {
		personRepository.save(person);
	}
}
