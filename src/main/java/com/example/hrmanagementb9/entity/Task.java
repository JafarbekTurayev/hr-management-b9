package com.example.hrmanagementb9.entity;

import com.example.hrmanagementb9.entity.enums.TaskState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Task {
    @Id
    @GeneratedValue
    private UUID id= UUID.randomUUID();
    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description; //  > 255

    @Enumerated(EnumType.STRING)
    private TaskState state = TaskState.NEW;

    private boolean completed = false;

    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    private Timestamp createTime;

    @UpdateTimestamp // chiqqan timeni yozadi
    @Column(nullable = false)
    private Timestamp endTime;


    @OneToMany
    private List<Employee> employeeList;

    //Har bir vazifa uchun vazifa nomi,
    // vazifa  haqida izoh,
    // vazifaning yakunlanishi kerak bo’lgan vaqti kiritiladi
    // va ushbu vazifaga xodim biriktiriladi.

}
