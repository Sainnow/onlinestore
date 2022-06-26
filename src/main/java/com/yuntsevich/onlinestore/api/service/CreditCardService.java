package com.yuntsevich.onlinestore.api.service;


import com.yuntsevich.onlinestore.dto.CreditCardDto;
import com.yuntsevich.onlinestore.exceptions.NotFoundException;

import java.util.List;

public interface CreditCardService {

    CreditCardDto save(CreditCardDto creditCardDto);

    CreditCardDto findById(Long id) throws NotFoundException;

    List<CreditCardDto> findAll();

    void deleteById(Long id);
}
