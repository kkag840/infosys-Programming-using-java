package com.business.sellingapp.model.dto;


import com.business.sellingapp.model.dao.Customer;
import com.business.sellingapp.model.dao.Product;
import com.business.sellingapp.model.dao.StatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private UUID id;
    private int orderNumber;
    private StatusType status;
    private Customer customer;
    private List<Product> products;

}
