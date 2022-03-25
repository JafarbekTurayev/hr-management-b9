package com.example.hrmanagementb9.repository;

import com.example.hrmanagementb9.entity.TurniKet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TurniKetRepository extends JpaRepository<TurniKet, UUID> {
}
