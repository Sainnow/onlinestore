package com.yuntsevich.onlinestore.service;


import com.yuntsevich.onlinestore.api.repository.ProductRepository;
import com.yuntsevich.onlinestore.api.service.ProductService;
import com.yuntsevich.onlinestore.dto.ProductDto;
import com.yuntsevich.onlinestore.exceptions.NotFoundException;
import com.yuntsevich.onlinestore.model.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private  final ModelMapper modelMapper;


    @Transactional
    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product response = productRepository.save(product);
        return modelMapper.map(response, ProductDto.class);
    }

    @Transactional
    @Override
    public ProductDto findById(Long id) throws NotFoundException {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return modelMapper.map(product, ProductDto.class);
    }

    @Transactional
    @Override
    public List<ProductDto> findAll() {
        List<Product> products =  productRepository.findAll();
        return products.stream().map(product -> modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
