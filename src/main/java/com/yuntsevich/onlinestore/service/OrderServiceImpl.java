package com.yuntsevich.onlinestore.service;


import com.yuntsevich.onlinestore.aop.LogExecutionTime;
import com.yuntsevich.onlinestore.api.repository.OrderRepository;
import com.yuntsevich.onlinestore.api.service.OrderService;
import com.yuntsevich.onlinestore.dto.OrderDto;
import com.yuntsevich.onlinestore.exceptions.NotFoundException;
import com.yuntsevich.onlinestore.model.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private  final ModelMapper modelMapper;

    @Transactional
    @Override
    public OrderDto save(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        Order response = orderRepository.save(order);
        return modelMapper.map(response, OrderDto.class);
    }

    @LogExecutionTime
    @Transactional
    @Override
    public OrderDto findById(Long id) throws NotFoundException {
        Order order = orderRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return modelMapper.map(order, OrderDto.class);
    }

    @Transactional
    @Override
    public List<OrderDto> findAll() {
        List<Order> orders =  orderRepository.findAll();
        return orders.stream().map(order -> modelMapper.map(order,OrderDto.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
