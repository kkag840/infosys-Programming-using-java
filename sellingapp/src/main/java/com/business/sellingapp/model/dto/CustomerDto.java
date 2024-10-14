package com.business.sellingapp.model.dto;


import com.business.sellingapp.model.dao.Address;
import com.business.sellingapp.model.dao.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private UUID id;
    private  String firstName;
    private String midName;
    private String lastName;
    private String email;
    private Address address;
    private List<Order> orders;
}
