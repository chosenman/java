package com.codingdojo.eventsbelt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.eventsbelt.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

}
