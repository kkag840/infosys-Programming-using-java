package com.business.sellingapp.service;

import com.business.sellingapp.model.dao.Product;
import com.business.sellingapp.model.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public List<ProductDto> getAllProducts();
    public ProductDto getProductById(UUID id);
    public ProductDto createProduct(ProductDto productDto);
    public ProductDto updateProduct(UUID id,ProductDto productDto);
    public  ProductDto updateProductDetails(UUID id,ProductDto productDto);
    public ProductDto deleteProduct(UUID id);
}
