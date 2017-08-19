package com.codingdojo.eventsbelt.services;

import org.springframework.stereotype.Service;

import com.codingdojo.eventsbelt.repositories.MessageRepository;

@Service
public class MessageService {
	
	private MessageRepository messageRepository;
	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
}
