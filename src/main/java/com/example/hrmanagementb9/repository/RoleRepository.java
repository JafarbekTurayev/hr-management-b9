package com.example.hrmanagementb9.repository;

import com.example.hrmanagementb9.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    boolean existsByName(String name);
}
