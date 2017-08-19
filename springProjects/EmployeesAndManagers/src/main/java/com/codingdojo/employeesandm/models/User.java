package com.codingdojo.employeesandm.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "friendships", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<User> friends;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "friendships", 
    joinColumns = @JoinColumn(name = "friend_id"), 
    inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userFriends;

    //...
    
    //...
    
    public List<User> getFriends() {
        return friends;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<User> getUserFriends() {
        return userFriends;
    }

    public void setUserFriends(List<User> userFriends) {
        this.userFriends = userFriends;
    }     
}
