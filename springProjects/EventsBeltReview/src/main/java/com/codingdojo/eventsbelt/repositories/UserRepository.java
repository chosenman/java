package com.codingdojo.eventsbelt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.eventsbelt.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    List<User> findAllByRolesNameContains(String arg);
//    User findOneByIdAndByRolesNameContains(Long id, String arg);
}

