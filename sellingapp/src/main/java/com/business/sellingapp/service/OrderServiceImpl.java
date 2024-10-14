package com.business.sellingapp.service;

import com.business.sellingapp.exception.NotFound;
import com.business.sellingapp.mapper.OrderMapper;
import com.business.sellingapp.model.dao.Customer;
import com.business.sellingapp.model.dao.Order;
import com.business.sellingapp.model.dto.OrderDto;
import com.business.sellingapp.repository.CustomerRepository;
import com.business.sellingapp.repository.OrderRepository;
import com.business.sellingapp.util.CommonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private  final OrderMapper orderMapper;
    private  final CustomerRepository customerRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,OrderMapper orderMapper,CustomerRepository customerRepository){
        this.orderMapper=orderMapper;
        this.orderRepository=orderRepository;
        this.customerRepository=customerRepository;
    }
    public List<OrderDto> getAllOrders(){
        return orderMapper.daoToDto(orderRepository.findAll());
    }
    public OrderDto getOrderById(UUID id){
        Optional<Order> order=orderRepository.findById(id);
        if(order.isPresent())
            return orderMapper.daoToDto(order.get());
        else
            throw new NotFound("Oder ID "+ id +" not found");
    }
    public OrderDto createOrder(UUID id,OrderDto orderDto){
            Optional<Customer>existingCustomer=customerRepository.findById(id);
            if(existingCustomer.isPresent()){
                Customer customer=existingCustomer.get();
                if(customer.getAddress()==null){
                    throw new NotFound("Address not found please enter the address first ");
                }
                Order order=orderMapper.dtoToDao(orderDto);
                order.setCustomer(customer);
                customer.getOrders().add(order);
                order=orderRepository.save(order);
                return orderMapper.daoToDto(order);
            }else
                throw new NotFound("Customer ID "+ id +" not found");

    }
    public OrderDto updateOrder(UUID id,OrderDto orderDto){
            Optional<Order>existingOrder=orderRepository.findById(id);
            if(existingOrder.isPresent()){
                Order order=existingOrder.get();
                order.setStatus(orderDto.getStatus());
                order.setProducts(orderDto.getProducts());
                order=orderRepository.save(order);
                return orderMapper.daoToDto(order);
            }else
                throw new NotFound("Oder ID "+ id +" not found");
    }
    public  OrderDto updateOrderDetails(UUID id,OrderDto orderDto){
        Optional<Order>existingOrder=orderRepository.findById(id);
        if(existingOrder.isPresent()){
            Order order=existingOrder.get();
            BeanUtils.copyProperties(orderDto,order, CommonUtil.getNullFields(orderDto));
            order=orderRepository.save(order);
            return orderMapper.daoToDto(order);
        }else
            throw new NotFound("Oder ID "+ id +" not found");
    }
    public OrderDto deleteOrder(UUID id){
        Optional<Order>existingOrder=orderRepository.findById(id);
        if(existingOrder.isPresent()){
            Order order=existingOrder.get();
            orderRepository.deleteById(id);
            return orderMapper.daoToDto(order);
        }else
            throw new NotFound("Oder ID "+ id +" not found");
    }
}
