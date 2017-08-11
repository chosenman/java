package com.codingdojo.grouplanguages.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.grouplanguages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{

}

