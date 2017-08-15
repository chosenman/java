package com.codingdojo.prandcatgories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.prandcatgories.models.Category;
import com.codingdojo.prandcatgories.models.Product;
import com.codingdojo.prandcatgories.services.CategoryService;
import com.codingdojo.prandcatgories.services.ProductService;

@Controller
public class ProductController {

	///
	private final ProductService productService;
	private final CategoryService categoryService;
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	///
	
	
    // One product
    @RequestMapping("/products/{id}")
    public String findProduct(Model model, @PathVariable("id") Long id) {
    			Product product = productService.findProductByIndex(id);
    			List<Category> categories = categoryService.findAllCategory();
    			if (product != null) {
	            model.addAttribute("product", product);
	            model.addAttribute("categories", categories);
	            return "product.jsp";
    			} else {
    				return "redirect:/";
    			}
    }
    @PostMapping("/products/newCategory")
    public String addNewCategory(
    		@RequestParam(value="category_id") Long category_id,
    		@RequestParam(value="product_id") Long product_id
    		) {
    		System.out.println(category_id);
    		System.out.println(product_id);
    		productService.addCategory(category_id, product_id);
    		return "redirect:/products/"+product_id;
    }
	
	
    // PRODUCT PAGE
    @RequestMapping("/products/new")
    public String newProduct(
    		Model model,
    		@Valid @ModelAttribute("product") Product product,
    		BindingResult result
    		) {		
    	
//    		List<Category> categories = ninjaService.findAllDojos();
    	
    		return "new_product.jsp";			
    	}
    @PostMapping("/products/new")
    public String createProductPost(
    		Model model,
    			@Valid @ModelAttribute("product") Product product,
    			BindingResult result
    		) {
    		if(result.hasErrors()) {
    			System.out.println("we have errors doing product");
    			return "new_product.jsp";
    		} else {
    			productService.setNewCategory(product);
    			return "redirect:/";
    		}
    	
    }
	
	
}
