package com.yuntsevich.onlinestore.api.repository;


import com.yuntsevich.onlinestore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String name);
}
