package com.yuntsevich.onlinestore.api.repository;


import com.yuntsevich.onlinestore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
