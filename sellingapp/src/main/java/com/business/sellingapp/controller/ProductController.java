package com.business.sellingapp.controller;

import com.business.sellingapp.model.dao.Product;
import com.business.sellingapp.model.dto.ProductDto;
import com.business.sellingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    
    private final ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
    }


    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable UUID id,@RequestBody ProductDto productDto){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id,productDto));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ProductDto> updateProductDetails(@PathVariable UUID id,@RequestBody ProductDto productDto){
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProductDetails(id,productDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable UUID id){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
    }

}
