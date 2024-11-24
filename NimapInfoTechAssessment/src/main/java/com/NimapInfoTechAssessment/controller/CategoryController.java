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

import com.NimapInfoTechAssessment.entity.Category;
import com.NimapInfoTechAssessment.productdto.CategoryDTO;
import com.NimapInfoTechAssessment.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/category")
public class CategoryController {

	@Autowired
	CategoryService cservice;
	
	@PostMapping("/add")
	public ResponseEntity<Category> saveCategory(@Valid @RequestBody Category category)
	{
		return new ResponseEntity<Category>(cservice.addCategory(category),HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{cid}")
	public ResponseEntity<Category> getCategory(@PathVariable("cid") Long cid)
	{
		return new ResponseEntity<Category>(cservice.getCategory(cid),HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{cid}")
	public ResponseEntity<String> deleteCategory(@PathVariable("cid") Long cid)
	{
		return new ResponseEntity<String>("Delete successfully...",HttpStatus.OK);
	}
	
	//use putmapping to edit existing data
	@PutMapping("/update/{cid}")
	public ResponseEntity<Category> editCategory(@PathVariable("cid") Long cid, @Valid @RequestBody Category category)
	{
		Category updateCategory=cservice.updateCategoryDetails(category , cid);
		return new ResponseEntity<Category>(updateCategory, HttpStatus.OK); 
	}
	
	@GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(@RequestParam int page, @RequestParam int size) {
        List<CategoryDTO> categories = cservice.getAllCategories(page, size);
        return ResponseEntity.ok(categories);
    }
		
}
