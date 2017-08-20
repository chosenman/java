package com.codingdojo.eventsbelt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="events")
public class Event {
	
    @Id
    @GeneratedValue
    private Long id;
    
    @Size(min=3, message="name must be greater than 3 characters")
    private String name;
    
    private Date eventDate;
    @Size(min=3, message="location must be greater than 3 characters")
    private String location;
    @Size(min=2, message=" state must be greater than 2 characters")
    private String state;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="host_id")
	 private User host;
    
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
	      name = "events_users",  
	      joinColumns = @JoinColumn(name = "event_id"), 
	      inverseJoinColumns = @JoinColumn(name = "user_ev_id")
	 )
	 private List<User> users;
	 
	 
	    @OneToMany(mappedBy="which_event", fetch = FetchType.LAZY)
	    private List<Comment> message_related_to_event;
    
    private Date createdAt;
    private Date updatedAt;
    
	 public Event() {
		 this.createdAt = new Date();
		 this.updatedAt = new Date();
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Comment> getMessage_related_to_event() {
		return message_related_to_event;
	}

	public void setMessage_related_to_event(List<Comment> message_related_to_event) {
		this.message_related_to_event = message_related_to_event;
	}
	 
	 
    

}
