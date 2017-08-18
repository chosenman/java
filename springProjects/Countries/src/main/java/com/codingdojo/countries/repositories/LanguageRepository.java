package com.codingdojo.countries.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.countries.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {

}
