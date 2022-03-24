package com.example.hrmanagementb9.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TuniketHistory {
    @Id
    @GeneratedValue
    private UUID id = UUID.randomUUID();

    @OneToOne
    private TurniKet turniKet;

    // kirgan va chiqqan vaqtlari :
    private boolean entered = false;

    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    private Timestamp enterTime;

    @UpdateTimestamp // chiqqan timeni yozadi
    @Column(nullable = false)
    private Timestamp exitTime;



}
