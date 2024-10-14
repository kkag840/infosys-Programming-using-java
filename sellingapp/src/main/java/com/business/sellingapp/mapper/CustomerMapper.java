package com.business.sellingapp.mapper;

import com.business.sellingapp.model.dao.Address;
import com.business.sellingapp.model.dao.Customer;
import com.business.sellingapp.model.dto.AddressDto;
import com.business.sellingapp.model.dto.CustomerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    private final ModelMapper modelMapper;
    @Autowired
    public CustomerMapper(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }


    public CustomerDto daoToDto(Customer customer){
        return modelMapper.map(customer,CustomerDto.class);
    }


    public Customer dtoToDao(CustomerDto customerDto){
        return modelMapper.map(customerDto,Customer.class);
    }

    public Address dtoToDao(AddressDto addressDto){
        return  modelMapper.map(addressDto,Address.class);
    }

    public List<CustomerDto> daoToDto(List<Customer> customers){
        return customers.stream().map(customer -> daoToDto(customer)).collect(Collectors.toList());
    }
}
