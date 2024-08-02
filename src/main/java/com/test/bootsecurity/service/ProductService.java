package com.test.bootsecurity.service;

import java.util.List;

import com.test.bootsecurity.model.Product;



public interface ProductService {

	List<Product> findAll();

	List<Product> findByCategory(String category);

	Product findById(int id);

}