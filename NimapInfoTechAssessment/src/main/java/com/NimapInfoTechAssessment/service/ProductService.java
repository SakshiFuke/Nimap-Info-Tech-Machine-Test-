package com.NimapInfoTechAssessment.service;

import java.util.List;

import com.NimapInfoTechAssessment.entity.Product;
import com.NimapInfoTechAssessment.productdto.ProductDTO;

public interface ProductService {

	Product addProduct(Product product);
	Product getProduct(Long pid);
	Product updateProduct(Product product,Long pid);
	void deleteProduct(Long pid);
	List<ProductDTO> getAllProduct(int page, int size);
}
