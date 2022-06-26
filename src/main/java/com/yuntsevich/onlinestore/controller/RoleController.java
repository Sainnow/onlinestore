package com.yuntsevich.onlinestore.controller;


import com.yuntsevich.onlinestore.api.service.RoleSerive;
import com.yuntsevich.onlinestore.dto.RoleDto;
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
@RequestMapping("/role")
public class RoleController {

    private  final RoleSerive roleSerive;

    @PostMapping
    public RoleDto save(@RequestBody RoleDto roleDto) {
        return roleSerive.save(roleDto);
    }

    @GetMapping("/{id}")
    public RoleDto findById(@PathVariable Long id) throws NotFoundException {
        return roleSerive.findById(id);
    }


    @GetMapping
    public List<RoleDto> findAll() {
        return roleSerive.findAll();
    }

    @PutMapping
    public RoleDto update(@RequestBody RoleDto roleDto) {
        return roleSerive.save(roleDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        roleSerive.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}