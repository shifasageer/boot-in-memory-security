package com.test.bootsecurity.resources;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.test.bootsecurity.model.Product;
import com.test.bootsecurity.service.ProductService;




@RestController
@RequestMapping("/product-service")
public class ProductController {

	
	@Autowired(required=true)
	ProductService product;

	@GetMapping("/products")
	public List<Product> findAll(){

	return product.findAll();

	}

	@GetMapping("/products-by-category/{category}")
	public List<Product> findByCategory(@PathVariable("category") String category){

		return product.findByCategory(category);
	}


	@PreAuthorize(value="hasRole('ADMIN')")
	@GetMapping("/products-by-id/{id}")
	public Product findById(@PathVariable("id") int id) {
		return product.findById(id);
	}


}