package com.yuntsevich.onlinestore.api.repository;


import com.yuntsevich.onlinestore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
