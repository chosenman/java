package com.codingdojo.eventsbelt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.eventsbelt.models.Event;
import com.codingdojo.eventsbelt.repositories.EventRepository;

@Service
public class EventService {

	private EventRepository eventRepository;
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public List<Event> findAll(){
		return (List<Event>) eventRepository.findAll();
	}
	public void setNewEvent(Event event) {
		eventRepository.save(event);
	}
	public Event findById(Long id){
		return eventRepository.findOne(id);
	}
}
