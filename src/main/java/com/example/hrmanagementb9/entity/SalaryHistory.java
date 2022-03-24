package com.example.hrmanagementb9.entity;

import com.example.hrmanagementb9.entity.enums.MonthEnum;
import com.example.hrmanagementb9.entity.enums.TaskState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SalaryHistory {
    @Id
    @GeneratedValue
    private UUID id= UUID.randomUUID();

    @ManyToOne
    private Employee employee; // qaysi employeega tegishliligi

    private Double amount;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private Date createTime;

    @Enumerated(EnumType.STRING)
    private MonthEnum monthEnum;

}
