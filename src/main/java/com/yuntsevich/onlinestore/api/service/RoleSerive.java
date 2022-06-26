package com.yuntsevich.onlinestore.api.service;


import com.yuntsevich.onlinestore.dto.RoleDto;
import com.yuntsevich.onlinestore.exceptions.NotFoundException;
import com.yuntsevich.onlinestore.model.Role;

import java.util.List;

public interface RoleSerive {


    RoleDto save(RoleDto roleDto);

    RoleDto findById(Long id) throws NotFoundException;

    List<RoleDto> findAll();

    void deleteById(Long id);

    Role findByRoleName(String name);
}
