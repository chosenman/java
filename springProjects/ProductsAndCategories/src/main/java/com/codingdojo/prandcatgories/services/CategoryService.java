package com.codingdojo.prandcatgories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.prandcatgories.models.Category;
import com.codingdojo.prandcatgories.models.Product;
import com.codingdojo.prandcatgories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public Category findCategoryByIndex(Long id){
		return categoryRepository.findOne(id);
	}
	
	
	public List<Category> findAllCategory(){
		return (List<Category>) categoryRepository.findAll();
	}
	public void setNewCategory(Category category) {
		categoryRepository.save(category);
	}
	

}
