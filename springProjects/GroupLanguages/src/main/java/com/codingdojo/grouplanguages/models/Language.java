package com.codingdojo.grouplanguages.models;


import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@ComponentScan("com.codingdojo.grouplanguages.models")
public class Language {

	@Id
    @GeneratedValue
    private Long id;
    
    @Column
    @Size(min = 2, max = 20)
    private String name;
    
    @Column
    @Size(min = 2, max = 20)
    private String creator;
    
    @Column
    @NotNull()
    private String cver;
    
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date created_at;

    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updated_at;
    
    
    public Language() {
    	
    }
    
    public Language(String name, String creator, String cver) {
        this.name = name;
        this.creator = creator;
        this.cver = cver;
    }
    
    public Long getId() {						return id;						}
	public void setId(Long id) {					this.id = id;					}
    
	public String getName() { 					return name;						}
    public void setName(String name) { 	 		this.name = name;  				}
    public String getCreator() {					return creator; 					}
    public void setCreator(String creator) { 		this.creator = creator; 			}
    public String getCver() {					return cver;						}
    public void setCver(String cver) {			this.cver = cver;				}
    @PrePersist
    protected void onCreate(){ 					this.created_at = new Date();	}
    @PreUpdate
    protected void onUpdate(){					this.updated_at = new Date();	}
    
}
