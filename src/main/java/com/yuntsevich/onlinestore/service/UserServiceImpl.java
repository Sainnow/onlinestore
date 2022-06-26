package com.yuntsevich.onlinestore.service;


import com.yuntsevich.onlinestore.api.repository.UserRepository;
import com.yuntsevich.onlinestore.api.service.UserService;
import com.yuntsevich.onlinestore.dto.UserDto;
import com.yuntsevich.onlinestore.exceptions.NotFoundException;
import com.yuntsevich.onlinestore.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private  final ModelMapper modelMapper;


    @Transactional
    @Override
    public UserDto save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User response = userRepository.save(user);
        return modelMapper.map(response, UserDto.class);
    }

    @Transactional
    @Override
    public UserDto findById(Long id) throws NotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User findByUsername(String name) {
        User result = userRepository.findByUsername(name);
        log.info("IN findByUsername - user: {} found by username: {}", result, name);
        return result;
    }

    @Transactional
    @Override
    public List<UserDto> findAll() {
        List<User> users =  userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }


    @Transactional
    @Override
    public void deleteById(Long id) { userRepository.deleteById(id); }
}
