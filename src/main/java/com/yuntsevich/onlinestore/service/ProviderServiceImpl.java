package com.yuntsevich.onlinestore.service;


import com.yuntsevich.onlinestore.api.repository.ProviderRepository;
import com.yuntsevich.onlinestore.api.service.ProviderService;
import com.yuntsevich.onlinestore.dto.ProviderDto;
import com.yuntsevich.onlinestore.exceptions.NotFoundException;
import com.yuntsevich.onlinestore.model.Provider;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;
    private  final ModelMapper modelMapper;


    @Transactional
    @Override
    public ProviderDto save(ProviderDto providerDto) {
        Provider provider = modelMapper.map(providerDto, Provider.class);
        Provider response = providerRepository.save(provider);
        return modelMapper.map(response, ProviderDto.class);
    }

    @Transactional
    @Override
    public ProviderDto findById(Long id) throws NotFoundException {
        Provider provider = providerRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return modelMapper.map(provider, ProviderDto.class);
    }

    @Transactional
    @Override
    public List<ProviderDto> findAll() {
        List<Provider> providers =  providerRepository.findAll();
        return providers.stream().map(provider -> modelMapper.map(provider,ProviderDto.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        providerRepository.deleteById(id);
    }
}
