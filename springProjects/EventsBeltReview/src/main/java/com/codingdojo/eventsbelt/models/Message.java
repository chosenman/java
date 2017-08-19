package com.codingdojo.eventsbelt.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="messages")
public class Message {

    @Id
    @GeneratedValue
    private Long id;
	
    @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="author_id")
	 private User author;
    
    @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="event_id")
	 private Event which_event;
	 
	 @Size(min=3, message="Message must be greater than 3 characters")
	 private String message;
	 
	 private Date createdAt;
	 private Date updatedAt;
	 
	 public Message() {
		 this.createdAt = new Date();
		 this.updatedAt = new Date();
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Event getWhich_event() {
		return which_event;
	}

	public void setWhich_event(Event which_event) {
		this.which_event = which_event;
	}
	 
	 
	 
}
