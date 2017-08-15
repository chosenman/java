package com.codingdojo.prandcatgories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.prandcatgories.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
