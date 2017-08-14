package com.codingdojo.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	
	private NinjaRepository ninjaRepository;
	private DojoRepository dojoRepository;
	public NinjaService(NinjaRepository ninjaRepository, DojoRepository dojoRepository) {
		this.ninjaRepository = ninjaRepository;
		this.dojoRepository = dojoRepository;
	}
	
	public void setNewNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	
	public List<Dojo> findAllDojos(){
		return (List<Dojo>) dojoRepository.findAll();
	}
}
