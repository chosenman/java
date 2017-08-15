package com.codingdojo.prandcatgories.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.codingdojo.prandcatgories.models.Category;
import com.codingdojo.prandcatgories.models.Product;
import com.codingdojo.prandcatgories.services.CategoryService;
import com.codingdojo.prandcatgories.services.ProductService;

@Controller
public class CategoryController {
	
	///
	private final CategoryService categoryService;
	private final ProductService productService;
	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	///
	
	
    @RequestMapping("/")
    public String index(
    		Model model
    		) {
    		model.addAttribute("allProducts", productService.findAllProducts());
    		model.addAttribute("allCategories", categoryService.findAllCategory());
    		return "index.jsp";			
    	}
    
    
    // One product
    @RequestMapping("/categories/{id}")
    public String findCategory(Model model, @PathVariable("id") Long id) {
    			Category category = categoryService.findCategoryByIndex(id);
    			if (category != null) {
	            model.addAttribute("category", category);
	            return "category.jsp";
    			} else {
    				return "redirect:/";
    			}
    }

    
    // CATEGORY PAGE
    @RequestMapping("/categories/new")
    public String newCaterogy(
    		Model model,
    		@Valid @ModelAttribute("category") Category category,
    		BindingResult result
    		) {		
    	
//    		List<Category> categories = ninjaService.findAllDojos();
    	
    		return "new_category.jsp";			
    	}
    @PostMapping("/categories/new")
    public String createCategoryPost(
    		Model model,
    			@Valid @ModelAttribute("category") Category category,
    			BindingResult result
    		) {
    		if(result.hasErrors()) {
    			System.out.println("we have errors doing category");
    			return "new_category.jsp";
    		} else {
    			categoryService.setNewCategory(category);
    			return "redirect:/";
    		}
    	
    }
    
}
