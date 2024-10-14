package com.business.sellingapp.repository;

import com.business.sellingapp.model.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
