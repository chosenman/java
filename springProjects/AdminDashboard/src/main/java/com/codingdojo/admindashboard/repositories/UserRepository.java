package com.codingdojo.admindashboard.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.admindashboard.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    List<User> findAllByRolesNameContains(String arg);
//    User findOneByIdAndByRolesNameContains(Long id, String arg);
}

