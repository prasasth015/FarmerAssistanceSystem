package com.cg.farmersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.farmersystem.exception.ProductNotFoundException;
import com.cg.farmersystem.model.Product;
import com.cg.farmersystem.service.ProductService;

@RestController

@RequestMapping(path = "/api/v1")

public class ProductController {

	@Autowired
	private ProductService productService;

	// Method to fetch the product from the database
	@GetMapping("/getproduct")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}

	// Method to create a product
	@PostMapping("/addproduct")
	public ResponseEntity<List<Product>> insertProduct(@RequestBody Product product) {
		List<Product> sq = productService.saveProduct(product);

		return new ResponseEntity<List<Product>>(sq, HttpStatus.OK);
	}

	// Method to delete product using product Id
	@DeleteMapping("/deleteproduct/{productId}")
	public String deleteProduct(@PathVariable(value = "productId") int productId) throws ProductNotFoundException {
		Product product = productService.getProductById(productId)
				.orElseThrow(() -> new ProductNotFoundException("No product found with this Id :" + productId));
		productService.deleteProduct(product);
		return "ProductNotFoundException.java Deleted";
	}

}
