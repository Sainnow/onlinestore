package com.yuntsevich.onlinestore.controller;


import com.yuntsevich.onlinestore.api.service.CreditCardService;
import com.yuntsevich.onlinestore.dto.CreditCardDto;
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
@RequestMapping("/creditcard")
public class CreditCardController {

    private  final CreditCardService creditCardService;

    @PostMapping
    public CreditCardDto save(@RequestBody CreditCardDto creditCardDto) {
        return creditCardService.save(creditCardDto);
    }

    @GetMapping("/{id}")
    public CreditCardDto findById(@PathVariable Long id) throws NotFoundException {
        return creditCardService.findById(id);
    }

    @GetMapping
    public List<CreditCardDto> findAll() {
        return creditCardService.findAll();
    }

    @PutMapping
    public CreditCardDto update(@RequestBody CreditCardDto creditCardDto) {
        return creditCardService.save(creditCardDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        creditCardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
