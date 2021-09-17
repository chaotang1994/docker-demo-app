package com.ex.dockerspringboothello.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.dockerspringboothello.model.Product;


@RestController
@RequestMapping("/product")
public class ProductController {

	static Map<String, Product> productMap = new HashMap<>();
	
	static {
		productMap.put("P1001", new Product("P1001", "Mobile",123));
		productMap.put("P1002", new Product("P1002", "Watch",32));
		productMap.put("P1003", new Product("P1003", "Laptop",756));
		productMap.put("P1004", new Product("P1004", "Charger",32));
	}
	
	

	@GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProductDetail(@PathVariable String productId) {
		
		Product product = productMap.get(productId);
		System.out.println("Product Detail : "+product);
		return product;
	}
	
}
