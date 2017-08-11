package com.codingdojo.lookify.models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@ComponentScan("com.codingdojo.lookify.models")
public class Song {

	@Id
    @GeneratedValue
    private Long id;
    
    @Column
    @Size(min = 5)
    private String title;
    
    @Column
    @Size(min = 5)
    private String artist;
    
    @Column
    @Max(10)
    private int rating;
    
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date created_at;

    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updated_at;
    
    
    public Song() {
    	
    }
    
    public Song(String title, String artist, int rating) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
    }
    
    public Long getId() {						return id;						}
	public void setId(Long id) {					this.id = id;					}
    
	public String getTitle() { 					return title;						}
    public void setTitle(String title) { 	 		this.title = title;  				}
    public String getArtist() {					return artist; 					}
    public void setArtist(String artist) { 		this.artist = artist; 			}
    public int getRating() {					return rating;						}
    public void setRating(int rating) {			this.rating = rating;				}
    @PrePersist
    protected void onCreate(){ 					this.created_at = new Date();	}
    @PreUpdate
    protected void onUpdate(){					this.updated_at = new Date();	}
    
}
