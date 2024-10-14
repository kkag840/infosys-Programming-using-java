package com.business.sellingapp.service;

import com.business.sellingapp.exception.NotFound;
import com.business.sellingapp.exception.EmailChangeNotAllowed;
import com.business.sellingapp.exception.EmailExists;
import com.business.sellingapp.mapper.CustomerMapper;
import com.business.sellingapp.model.dao.Customer;
import com.business.sellingapp.model.dto.AddressDto;
import com.business.sellingapp.model.dto.CustomerDto;
import com.business.sellingapp.repository.CustomerRepository;
import com.business.sellingapp.util.CommonUtil;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{
    private  final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerMapper customerMapper,CustomerRepository customerRepository){
        this.customerMapper=customerMapper;
        this.customerRepository=customerRepository;
    }

    @Override
    public List<CustomerDto> getAllCustomers(){
        return customerMapper.daoToDto(customerRepository.findAll());
    }

    @Override
    public CustomerDto getCustomerById(UUID id){
        Optional<Customer>customer=customerRepository.findById(id);
        if(customer.isPresent())
            return customerMapper.daoToDto(customer.get());
        else{
            throw new NotFound("Customer ID " + id + " not found");
        }
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto){
        if(StringUtils.isBlank(customerDto.getFirstName()))
            throw new IllegalArgumentException("first name is required");

        if(StringUtils.isBlank(customerDto.getLastName()))
            throw new IllegalArgumentException("Last name  is required");

        if(StringUtils.isBlank(customerDto.getEmail()))
            throw new IllegalArgumentException("Emaill is required");

        if(customerRepository.findByEmailIgnoreCase(customerDto.getEmail()).isPresent())
            throw new EmailExists("Email "+ customerDto.getEmail() +" already exists");

        Customer customer=customerMapper.dtoToDao(customerDto);
        customer=customerRepository.save(customer);
        return customerMapper.daoToDto(customer);

    }

    @Override
    public CustomerDto updateCustomer(UUID id,CustomerDto customerDto){
        Optional<Customer> existingCustomer=customerRepository.findById(id);

        if(existingCustomer.isPresent()){
            Customer customer=existingCustomer.get();

            if(!customer.getEmail().equals(customerDto.getEmail()))
                throw new EmailChangeNotAllowed("email cannot be changed");

            if (customerDto.getAddress() != null) {
                customer.setAddress(customerDto.getAddress());
            }

            customer.setFirstName(customerDto.getFirstName());
            customer.setLastName(customerDto.getLastName());
            customer.setMidName(customerDto.getMidName());
            customer.setAddress(customerDto.getAddress());

            customer=customerRepository.save(customer);
            return customerMapper.daoToDto(customer);
        }else
            throw new NotFound("Customer ID "+ id +" not found");
    }

    @Override
    public  CustomerDto updateCustomerDetails(UUID id,CustomerDto customerDto){
            Optional<Customer> existingCustomer=customerRepository.findById(id);
            if(existingCustomer.isPresent()){
                Customer customer=existingCustomer.get();

                if(StringUtils.isNotBlank(customerDto.getEmail())){
                    if(!customer.getEmail().equals(customerDto.getEmail()))
                        throw new EmailChangeNotAllowed("email cannot be changed");
                }

                BeanUtils.copyProperties(customerDto,customer, CommonUtil.getNullFields(customerDto));

                customer=customerRepository.save(customer);
                return customerMapper.daoToDto(customer);
            }else
                throw new NotFound("Customer ID "+ id + " not found");
    }

    @Override
    public CustomerDto deleteCustomer(UUID id){
        Optional<Customer> customer=customerRepository.findById(id);
        if(customer.isPresent()){
            customerRepository.deleteById(id);
            return customerMapper.daoToDto(customer.get());
        }else
            throw new NotFound("Customer ID "+ id + " not found");
    }

    @Override
    public CustomerDto addAddress(UUID id, AddressDto addressDto){
        Optional<Customer>existingcustomer=customerRepository.findById(id);
        if(existingcustomer.isPresent()) {
            Customer customer = existingcustomer.get();
            customer.setAddress(customerMapper.dtoToDao(addressDto));
            customer = customerRepository.save(customer);
            return customerMapper.daoToDto(customer);
        }else
            throw new NotFound("Customer ID "+ id + " not found");
    }
}
