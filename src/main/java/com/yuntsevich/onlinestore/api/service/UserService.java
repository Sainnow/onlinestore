package com.yuntsevich.onlinestore.api.service;


import com.yuntsevich.onlinestore.dto.UserDto;
import com.yuntsevich.onlinestore.exceptions.NotFoundException;
import com.yuntsevich.onlinestore.model.User;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);

    UserDto  findById(Long id) throws NotFoundException;

    User findByUsername(String username);

    List<UserDto> findAll();

    void deleteById(Long id);
}
