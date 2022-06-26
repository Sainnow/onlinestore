package com.yuntsevich.onlinestore.api.service;


import com.yuntsevich.onlinestore.dto.OrderDto;
import com.yuntsevich.onlinestore.exceptions.NotFoundException;

import java.util.List;

public interface OrderService {

    OrderDto save(OrderDto orderDto);

    OrderDto findById(Long id) throws NotFoundException;

    List<OrderDto> findAll();

    void deleteById(Long id);
}
