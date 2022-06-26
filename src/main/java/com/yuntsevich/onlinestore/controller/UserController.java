package com.yuntsevich.onlinestore.controller;


import com.yuntsevich.onlinestore.api.service.UserService;
import com.yuntsevich.onlinestore.dto.UserDto;
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
@RequestMapping("/user")
public class UserController {

    private  final UserService userService;

    @PostMapping
    public UserDto save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) throws NotFoundException {
        return userService.findById(id);
    }


    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
