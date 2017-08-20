package com.codingdojo.eventsbelt.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.eventsbelt.models.Event;
import com.codingdojo.eventsbelt.models.Role;
import com.codingdojo.eventsbelt.models.User;
import com.codingdojo.eventsbelt.repositories.EventRepository;
import com.codingdojo.eventsbelt.repositories.RoleRepository;
import com.codingdojo.eventsbelt.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private EventRepository eventRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(
    		UserRepository userRepository, 
    		RoleRepository roleRepository, 
    		EventRepository eventRepository, 
    		BCryptPasswordEncoder bCryptPasswordEncoder)     {
	        this.userRepository = userRepository;
	        this.roleRepository = roleRepository;
	        this.eventRepository = eventRepository;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    // 3
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public List<User> findAnyAdminRole() {
        return (List<User>) userRepository.findAllByRolesNameContains("ROLE_ADMIN");
//        return (List<User>) userRepository.findAllByRolesNameContains("ROLE_USER");
    }
    
    public List<User> findAll(){
    		return (List<User>) userRepository.findAll();
    }
    public Role findAdmin() {
    		return roleRepository.findOne(Long.parseLong("2"));
    }
    
    public Boolean ifThisUserisAdmin(Long id) {
    		Boolean answer = false;
         List<User> users =  userRepository.findAllByRolesNameContains("ROLE_ADMIN");

         for(User user : users) {
	        	 	if(user.getId() == id) { 	answer = true;		}
         }
         return answer;
    }
    
    public void delete(Long id) {
    		userRepository.delete(id);;
    }
    
    public User findById(Long id) {
    		return userRepository.findOne(id);
    }
    
    /// join
    public void joinEvent(Long event_id, Long user_id) {
    		User user = userRepository.findOne(user_id);
    		Event event = eventRepository.findOne(event_id);
        	event.getUsers().add(user);
        	eventRepository.save(event);
    }
    
    /// CANCELjoin
    public void cancelJoinEvent(Long event_id, Long user_id) {
    		User user = userRepository.findOne(user_id);
    		Event event = eventRepository.findOne(event_id);
        	event.getUsers().remove(user);
        	eventRepository.save(event);
    }
    
}