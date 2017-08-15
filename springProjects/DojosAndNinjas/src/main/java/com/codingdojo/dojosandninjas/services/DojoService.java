package com.codingdojo.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	private DojoRepository dojoRepository;
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public void setNewDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	public Dojo findOne(Long id) {
		return dojoRepository.findOne(id);
	}
	
	public List<Dojo> findAllDojo(){
		return (List<Dojo>) dojoRepository.findAll();
	}
}
