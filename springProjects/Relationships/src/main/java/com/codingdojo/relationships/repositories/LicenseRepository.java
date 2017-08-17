package com.codingdojo.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;

public interface LicenseRepository extends CrudRepository<License, Long> {
//	List<License> findAllWithoutPerson();
	List<Person> findAllPersonByPersonLicenseNull();
//	List<Person> findOneByStateNotNull();
//	findAll, findOne, findBy Number NotNull, Null Contains("sdfsdfl")

}
