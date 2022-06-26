package com.yuntsevich.onlinestore.api.service;


import com.yuntsevich.onlinestore.dto.ProductDto;
import com.yuntsevich.onlinestore.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto productDto);

    ProductDto findById(Long id) throws NotFoundException;

    List<ProductDto> findAll();

    void deleteById(Long id);
}
