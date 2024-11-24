package com.NimapInfoTechAssessment.service;

import java.util.List;

import com.NimapInfoTechAssessment.entity.Category;
import com.NimapInfoTechAssessment.productdto.CategoryDTO;

public interface CategoryService {

	Category addCategory(Category category);
	Category getCategory(Long cid);
	Category updateCategoryDetails(Category category,Long cid);
	void deleteCategoryDetails(Long cid);
	List<CategoryDTO> getAllCategories(int page, int size);
}