package com.yuntsevich.onlinestore.controller;

import com.yuntsevich.onlinestore.api.service.ProductService;
import com.yuntsevich.onlinestore.dto.ProductDto;
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
@RequestMapping("/product")
public class ProductController {

    private  final ProductService productService;

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) throws NotFoundException {
        return productService.findById(id);
    }

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @PutMapping
    public ProductDto update(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
