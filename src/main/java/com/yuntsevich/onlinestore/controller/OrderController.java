package com.yuntsevich.onlinestore.controller;


import com.yuntsevich.onlinestore.api.service.OrderService;
import com.yuntsevich.onlinestore.dto.OrderDto;
import com.yuntsevich.onlinestore.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private  final OrderService orderService;

    @PostMapping
    public OrderDto save(@RequestBody OrderDto orderDto) {
        return orderService.save(orderDto);
    }

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Long id) throws NotFoundException {
        return orderService.findById(id);
    }

    @GetMapping
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }

    @PutMapping
    public OrderDto update(@RequestBody OrderDto orderDto) {
        return orderService.save(orderDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
