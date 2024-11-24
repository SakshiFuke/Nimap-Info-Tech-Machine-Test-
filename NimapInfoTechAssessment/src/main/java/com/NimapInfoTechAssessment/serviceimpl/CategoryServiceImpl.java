package com.NimapInfoTechAssessment.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.NimapInfoTechAssessment.entity.Category;
import com.NimapInfoTechAssessment.exception.CategoryIdNotFoundException;
import com.NimapInfoTechAssessment.productdto.CategoryDTO;
import com.NimapInfoTechAssessment.repository.CategoryRepository;
import com.NimapInfoTechAssessment.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	@Override
	public Category addCategory(Category category) {
		return categoryRepo.save(category);	
	}

	@Override
	public Category getCategory(Long cid) {
		return categoryRepo.findById(cid).orElseThrow(()->new CategoryIdNotFoundException("Category id is not correct "));
	}

	@Override
	public Category updateCategoryDetails(Category category, Long cid) {
		Category UpdateCategory =categoryRepo.findById(cid).orElseThrow(()->new CategoryIdNotFoundException("Category id is not correct "));
		UpdateCategory.setName(category.getName());
		return categoryRepo.save(UpdateCategory);
		
	}

	@Override
	public void deleteCategoryDetails(Long cid) {
		Category deleteCategory=categoryRepo.findById(cid).orElseThrow(()->new CategoryIdNotFoundException("Category id is not correct "));
		categoryRepo.delete(deleteCategory);
	}

	@Override
	public List<CategoryDTO> getAllCategories(int page, int size) {
		var pageable = PageRequest.of(page, size);
        var categories = categoryRepo.findAll(pageable).getContent();
        return categories.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
	
	private CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryid(category.getCategoryid());
        dto.setName(category.getName());
        return dto;
    }
}
