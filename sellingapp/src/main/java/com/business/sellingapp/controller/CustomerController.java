package com.business.sellingapp.controller;

import com.business.sellingapp.model.dao.Customer;
import com.business.sellingapp.model.dto.AddressDto;
import com.business.sellingapp.model.dto.CustomerDto;
import com.business.sellingapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    private CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        return  ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerDto));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<CustomerDto>  updateCustomer(@PathVariable UUID id,@RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(id,customerDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerDto>  updateCustomerDetails(@PathVariable UUID id,@RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomerDetails(id,customerDto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.deleteCustomer(id));
    }

    @GetMapping("/{id}/address")
    public  ResponseEntity<CustomerDto> addAddress(@PathVariable UUID id, @RequestBody AddressDto addressDto){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.addAddress(id,addressDto));
    }

}
