package com.business.sellingapp.model.dao;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "order_number")
    private String orderNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;
    @Column(name="date_time")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "orders_products",
                joinColumns = @JoinColumn(name = "orders_id"),
                inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @PrePersist
    public  void setOrdersDetails(){
        this.orderNumber = UUID.randomUUID().toString();
        this.dateTime=LocalDateTime.now();
        this.status=StatusType.INITIATED;
    }

}
