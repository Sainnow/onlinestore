package com.yuntsevich.onlinestore.api.service;


import com.yuntsevich.onlinestore.dto.ProviderDto;
import com.yuntsevich.onlinestore.exceptions.NotFoundException;

import java.util.List;

public interface ProviderService {

    ProviderDto save(ProviderDto providerDto);

    ProviderDto findById(Long id) throws NotFoundException;

    List<ProviderDto> findAll();

    void deleteById(Long id);
}
