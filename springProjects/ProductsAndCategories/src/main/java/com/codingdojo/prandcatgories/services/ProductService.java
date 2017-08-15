package com.codingdojo.prandcatgories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.prandcatgories.models.Category;
import com.codingdojo.prandcatgories.models.Product;
import com.codingdojo.prandcatgories.repositories.CategoryRepository;
import com.codingdojo.prandcatgories.repositories.ProductRepository;


@Service
public class ProductService {
	
	private ProductRepository productRepository;
	private CategoryRepository categorytRepository;
	public ProductService(ProductRepository productRepository, CategoryRepository categorytRepository) {
		this.productRepository = productRepository;
		this.categorytRepository = categorytRepository;
	}

	public Product findProductByIndex(Long id){
		return productRepository.findOne(id);
	}
	public List<Product> findAllProducts(){
		return (List<Product>) productRepository.findAll();
	}
	
	public void setNewCategory(Product product) {
		productRepository.save(product);
	}
	
	public void addCategory(Long category_id, Long product_id) {
		Product product = productRepository.findOne(product_id);
		product.getCategories().add(categorytRepository.findOne(category_id));
		productRepository.save(product);
	}
	
//	public List<Product> findAllNotCategorizedProducts(){
//		return (List<Product>) productRepository.findAll();
//	}
}
