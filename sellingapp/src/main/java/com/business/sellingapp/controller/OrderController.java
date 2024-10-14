package com.business.sellingapp.controller;

import com.business.sellingapp.model.dto.OrderDto;
import com.business.sellingapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/{customerid}/orders")
public class OrderController {
    
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getProductById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderById(id));
    }


    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@PathVariable UUID customerid,@RequestBody OrderDto orderDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(customerid,orderDto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable UUID id,@RequestBody OrderDto orderDto){
        return  ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(id,orderDto));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrderDetails(@PathVariable UUID id,@RequestBody OrderDto orderDto){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrderDetails(id,orderDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDto> deleteOrder(@PathVariable UUID id){
        return  ResponseEntity.status(HttpStatus.OK).body(orderService.deleteOrder(id));
    }
}
