package com.business.sellingapp.service;

import com.business.sellingapp.model.dto.OrderDto;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    public List<OrderDto> getAllOrders();
    public OrderDto getOrderById(UUID id);
    public OrderDto createOrder(UUID id,OrderDto orderDto);
    public OrderDto updateOrder(UUID id,OrderDto orderDto);
    public  OrderDto updateOrderDetails(UUID id,OrderDto orderDto);
    public OrderDto deleteOrder(UUID id);
}
