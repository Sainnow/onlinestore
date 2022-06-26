package com.yuntsevich.onlinestore.controller;


import com.yuntsevich.onlinestore.api.service.ProviderService;
import com.yuntsevich.onlinestore.dto.ProviderDto;
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
@RequestMapping("/provider")
public class ProviderController {

    private  final ProviderService providerService;

    @PostMapping
    public ProviderDto save(@RequestBody ProviderDto providerDto) {
        return providerService.save(providerDto);
    }

    @GetMapping("/{id}")
    public ProviderDto findById(@PathVariable Long id) throws NotFoundException {
        return providerService.findById(id);
    }

    @GetMapping
    public List<ProviderDto> findAll() {
        return providerService.findAll();
    }

    @PutMapping
    public ProviderDto update(@RequestBody ProviderDto providerDto) {
        return providerService.save(providerDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        providerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
