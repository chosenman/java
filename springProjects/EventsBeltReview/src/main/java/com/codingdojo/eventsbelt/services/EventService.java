package com.codingdojo.eventsbelt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.eventsbelt.models.Comment;
import com.codingdojo.eventsbelt.models.Event;
import com.codingdojo.eventsbelt.repositories.CommentRepository;
import com.codingdojo.eventsbelt.repositories.EventRepository;

@Service
public class EventService {

	private EventRepository eventRepository;
	private CommentRepository commentRepository;
	public EventService(EventRepository eventRepository, CommentRepository commentRepository) {
		this.eventRepository = eventRepository;
		this.commentRepository = commentRepository;
	}
	
	public List<Event> findAll(){
		return (List<Event>) eventRepository.findAll();
	}
	public void setNewEvent(Event event) {
		eventRepository.save(event);
	}
	public void editEvent(Event event, Long id) {
		Event edited_event = eventRepository.findOne(id);
		edited_event.setName(event.getName());
		edited_event.setEventDate(event.getEventDate());
		edited_event.setLocation(event.getLocation());
		edited_event.setState(event.getState());
//		edited_event = event;
		eventRepository.save(edited_event);
	}
	public Event findById(Long id){
		return eventRepository.findOne(id);
	}
	
    /// Delete event
    public void deleteEvent(Long event_id) {

//		try { 
			Event event = eventRepository.findOne(event_id);
    			List<Comment> comments = commentRepository.findAll();
    	         for(Comment comment : comments) {
 	        	 	if(comment.getWhich_event().getId().equals(event_id)) { 	
 	        	 		commentRepository.delete(comment);
 	        	 		}
    	         }
    			eventRepository.delete(event);
//		} catch (Exception e) {  System.out.println("oops"); }
    }
	
}
