package com.business.sellingapp.mapper;

import com.business.sellingapp.model.dao.Product;
import com.business.sellingapp.model.dto.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private final ModelMapper modelMapper;
    @Autowired
    public ProductMapper(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }


    public ProductDto daoToDto(Product product){
        return modelMapper.map(product,ProductDto.class);
    }


    public Product dtoToDao(ProductDto productDto){
        return modelMapper.map(productDto,Product.class);
    }

    public List<ProductDto> daoToDto(List<Product> products){
        return products.stream().map(product -> daoToDto(product)).collect(Collectors.toList());
    }
}
