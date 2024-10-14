package com.business.sellingapp.service;

import com.business.sellingapp.exception.NotFound;
import com.business.sellingapp.mapper.ProductMapper;
import com.business.sellingapp.model.dao.Product;
import com.business.sellingapp.model.dto.ProductDto;
import com.business.sellingapp.repository.ProductRepository;
import com.business.sellingapp.util.CommonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements  ProductService{

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper,ProductRepository productRepository){
        this.productMapper=productMapper;
        this.productRepository=productRepository;
    }
    public List<ProductDto> getAllProducts(){
        return productMapper.daoToDto(productRepository.findAll());
    }
    public ProductDto getProductById(UUID id){
        Optional<Product> product=productRepository.findById(id);
        if(product.isPresent())
            return productMapper.daoToDto(product.get());
        else{
            throw new NotFound("Product ID " + id + " not found");
        }

    }
    public ProductDto createProduct(ProductDto productDto){
            Product  product=productRepository.save(productMapper.dtoToDao(productDto));
            return productMapper.daoToDto(product);
    }
    public ProductDto updateProduct(UUID id,ProductDto productDto){
        Optional<Product> existingProduct=productRepository.findById(id);
        if(existingProduct.isPresent()){
            Product product=existingProduct.get();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product=productRepository.save(product);
            return productMapper.daoToDto(product);
        }else
            throw new NotFound("Product ID " + id + " not found");
    }
    public  ProductDto updateProductDetails(UUID id,ProductDto productDto){

        Optional<Product> existingProduct=productRepository.findById(id);
        if(existingProduct.isPresent()){
            Product product=existingProduct.get();
            BeanUtils.copyProperties(productDto,product, CommonUtil.getNullFields(productDto));
            product=productRepository.save(product);
            return productMapper.daoToDto(product);
        }else
            throw new NotFound("Product ID " + id + " not found");

    }
    public ProductDto deleteProduct(UUID id){
        Optional<Product> existingProduct=productRepository.findById(id);
        if(existingProduct.isPresent()){
            productRepository.deleteById(id);
            return productMapper.daoToDto(existingProduct.get());
        }else
            throw new NotFound("Product ID " + id + " not found");
    }
}
