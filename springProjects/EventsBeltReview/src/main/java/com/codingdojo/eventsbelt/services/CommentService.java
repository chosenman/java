package com.codingdojo.eventsbelt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.eventsbelt.models.Comment;
import com.codingdojo.eventsbelt.repositories.CommentRepository;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public void setNewMessage(Comment comment) {
		commentRepository.save(comment);
	}
	
	public List<Comment> findAll(){
		return commentRepository.findAll();
	}
	
//	public List<UserMessage> findAllByWhich_event(Event event){
//		return (List<UserMessage>) userMessageRepository.findAllByWhich_event(event);
//	}
	public ArrayList<Comment> findByEventId(Long id){
		List<Comment> givenAll = commentRepository.findAll();
		ArrayList<Comment> result = new ArrayList<Comment>();
		for(Comment msg : givenAll) {
			if(msg.getWhich_event().getId() == id) {
				result.add( msg);
			}
		}
		return result;
	}
}
