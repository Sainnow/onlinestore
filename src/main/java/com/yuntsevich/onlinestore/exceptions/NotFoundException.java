package com.yuntsevich.onlinestore.exceptions;


public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("entity with id: " + id + " was not found");
    }

}

