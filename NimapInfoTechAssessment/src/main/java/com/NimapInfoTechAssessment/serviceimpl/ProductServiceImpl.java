package com.NimapInfoTechAssessment.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.NimapInfoTechAssessment.entity.Product;
import com.NimapInfoTechAssessment.exception.ProductIdNotFoundException;
import com.NimapInfoTechAssessment.productdto.ProductDTO;
import com.NimapInfoTechAssessment.repository.CategoryRepository;
import com.NimapInfoTechAssessment.repository.ProductRepository;
import com.NimapInfoTechAssessment.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product getProduct(Long pid) {
		return productRepo.findById(pid).orElseThrow(()->new ProductIdNotFoundException("Product id is not correct "));
	}

	@Override
	public Product updateProduct(Product product, Long pid) {
		Product UpdateProduct =productRepo.findById(pid).orElseThrow(()->new ProductIdNotFoundException("Product id is not correct "));
		UpdateProduct.setName(product.getName());
		return productRepo.save(UpdateProduct);
		
	}

	@Override
	public void deleteProduct(Long pid) {
		Product deleteProduct=productRepo.findById(pid).orElseThrow(()->new ProductIdNotFoundException("Product id is not correct "));
		productRepo.delete(deleteProduct);
	}
	
	@Override
	public List<ProductDTO> getAllProduct(int page, int size) {
		var pageable = PageRequest.of(page, size);
        var products = productRepo.findAll(pageable).getContent();
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
	
	private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductsId(product.getProductsId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setCategoryid(product.getCategory().getCategoryid());
        return dto;
    }
	
	public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
	    Product product = productRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found"));
	    product.setName(productDTO.getName());
	    product.setPrice(productDTO.getPrice());
	    product.setCategory(categoryRepo.findById(productDTO.getCategoryid())
	            .orElseThrow(() -> new RuntimeException("Category not found")));
	    product = productRepo.save(product);
	    return convertToDTO(product);
	}
}
