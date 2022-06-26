package com.yuntsevich.onlinestore.service;



import com.yuntsevich.onlinestore.api.repository.CreditCardRepository;
import com.yuntsevich.onlinestore.api.service.CreditCardService;
import com.yuntsevich.onlinestore.dto.CreditCardDto;
import com.yuntsevich.onlinestore.exceptions.NotFoundException;
import com.yuntsevich.onlinestore.model.CreditCard;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private  final ModelMapper modelMapper;


    @Transactional
    @Override
    public CreditCardDto save(CreditCardDto creditCardDto) {
        CreditCard creditCard = modelMapper.map(creditCardDto, CreditCard.class);
        CreditCard response = creditCardRepository.save(creditCard);
        return modelMapper.map(response, CreditCardDto.class);
    }

    @Transactional
    @Override
    public CreditCardDto findById(Long id) throws NotFoundException {
        CreditCard creditCard = creditCardRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return modelMapper.map(creditCard, CreditCardDto.class);
    }

    @Transactional
    @Override
    public List<CreditCardDto> findAll() {
        List<CreditCard> creditCards =  creditCardRepository.findAll();
        return creditCards.stream().map(creditCard -> modelMapper.map(creditCard,CreditCardDto.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        creditCardRepository.deleteById(id);
    }
}
