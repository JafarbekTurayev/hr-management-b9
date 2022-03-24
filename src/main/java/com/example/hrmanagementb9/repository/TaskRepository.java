package com.example.hrmanagementb9.repository;

import com.example.hrmanagementb9.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    boolean existsByName(String name);
}
