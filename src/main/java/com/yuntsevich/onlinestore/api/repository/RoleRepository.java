package com.yuntsevich.onlinestore.api.repository;


import com.yuntsevich.onlinestore.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(String name);
}
