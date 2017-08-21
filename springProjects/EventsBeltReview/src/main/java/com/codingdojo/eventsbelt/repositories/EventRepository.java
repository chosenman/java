package com.codingdojo.eventsbelt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.eventsbelt.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	
//    @Transactional
//    void deleteById(Long Id);
}
