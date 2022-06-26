package com.yuntsevich.onlinestore.service;


import com.yuntsevich.onlinestore.api.repository.RoleRepository;
import com.yuntsevich.onlinestore.api.service.RoleSerive;
import com.yuntsevich.onlinestore.dto.RoleDto;
import com.yuntsevich.onlinestore.exceptions.NotFoundException;
import com.yuntsevich.onlinestore.model.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleSerive {

    private final RoleRepository roleRepository;
    private  final ModelMapper modelMapper;

    @Transactional
    @Override
    public RoleDto save(RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);
        Role response = roleRepository.save(role);
        return modelMapper.map(response, RoleDto.class);
    }

    @Transactional
    @Override
    public RoleDto findById(Long id) throws NotFoundException {
        Role role = roleRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return modelMapper.map(role, RoleDto.class);
    }

    @Transactional
    @Override
    public List<RoleDto> findAll() {
        List<Role> roles =  roleRepository.findAll();
        return roles.stream().map(role -> modelMapper.map(role,RoleDto.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findByRoleName(String name) {
        Role result = roleRepository.findByRoleName(name);
        log.info("IN findByUsername - user: {} found by username: {}", result, name);
        return result;
    }
}
