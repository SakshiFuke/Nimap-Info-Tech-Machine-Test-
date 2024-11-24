package com.NimapInfoTechAssessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NimapInfoTechAssessment.entity.Product;
import com.NimapInfoTechAssessment.productdto.ProductDTO;
import com.NimapInfoTechAssessment.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	ProductService pservice;
	
	@PostMapping("/add")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product)
	{
		return new ResponseEntity<Product>(pservice.addProduct(product),HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{pid}")
	public ResponseEntity<Product> getProduct(@PathVariable("pid") Long pid)
	{
		return new ResponseEntity<Product>(pservice.getProduct(pid),HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{pid}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("pid") Long pid)
	{
		pservice.deleteProduct(pid);
		return ResponseEntity.noContent().build();
	}
	
	//use putmapping to edit existing data
		@PutMapping("/update/{pid}")
		public ResponseEntity<Product> editProduct(@PathVariable("pid") Long pid, @Valid @RequestBody Product product)
		{
			Product updateProduct=pservice.updateProduct(product , pid);
			return new ResponseEntity<Product>(updateProduct, HttpStatus.OK); 
		}
		@GetMapping
	    public ResponseEntity<List<ProductDTO>> getAllProduct(@RequestParam int page, @RequestParam int size) {
	        List<ProductDTO> products = pservice.getAllProduct(page, size);
	        return ResponseEntity.ok(products);
	    }
		
		
}
