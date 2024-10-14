package com.business.sellingapp.mapper;

import com.business.sellingapp.model.dao.Order;
import com.business.sellingapp.model.dto.OrderDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    private final ModelMapper modelMapper;
    @Autowired
    public OrderMapper(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public OrderDto daoToDto(Order order){
        return modelMapper.map(order,OrderDto.class);
    }


    public Order dtoToDao(OrderDto orderDto){
        return modelMapper.map(orderDto,Order.class);
    }

    public List<OrderDto> daoToDto(List<Order> orders){
        return orders.stream().map(order -> daoToDto(order)).collect(Collectors.toList());
    }
}
