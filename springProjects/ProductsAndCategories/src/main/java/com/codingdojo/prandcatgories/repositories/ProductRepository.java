package com.codingdojo.prandcatgories.repositories;

import java.util.List;

import org.omg.CORBA.Current;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.prandcatgories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
//	List<Product> findAllCategoriesByIdEqualCategoriesId();
//	List<Product> findAll Categories where Current PRODUCT_ID NOT equal products_id ();
//	List<Product> findByCattegoriesProduct_id(Long id);
}
