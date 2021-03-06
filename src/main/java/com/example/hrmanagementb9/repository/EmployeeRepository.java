package com.example.hrmanagementb9.repository;

import com.example.hrmanagementb9.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
boolean existsByUsername(String Username);
boolean existsByEmail(String Username);
Optional<Employee> findByUsername(String userName);




}
