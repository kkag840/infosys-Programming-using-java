package com.business.sellingapp.service;

import com.business.sellingapp.model.dao.Customer;
import com.business.sellingapp.model.dto.AddressDto;
import com.business.sellingapp.model.dto.CustomerDto;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    public List<CustomerDto> getAllCustomers();
    public CustomerDto getCustomerById(UUID id);
    public CustomerDto createCustomer(CustomerDto customerDto);
    public CustomerDto updateCustomer(UUID id,CustomerDto customerDto);
    public  CustomerDto updateCustomerDetails(UUID id,CustomerDto customerDto);
    public CustomerDto deleteCustomer(UUID id);
    public CustomerDto addAddress(UUID id, AddressDto addressDto);
}
