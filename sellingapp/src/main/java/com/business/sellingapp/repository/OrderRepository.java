package com.business.sellingapp.repository;

import com.business.sellingapp.model.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order,UUID> {
}
