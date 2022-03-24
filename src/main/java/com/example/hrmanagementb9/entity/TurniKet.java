package com.example.hrmanagementb9.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TurniKet {
    @Id
    @GeneratedValue
    private UUID id=UUID.randomUUID();

    @OneToOne
    private Employee employee;







}

