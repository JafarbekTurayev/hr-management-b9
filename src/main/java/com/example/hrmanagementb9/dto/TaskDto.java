package com.example.hrmanagementb9.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {
    private String name;
    private String description;
    private UUID employeeId;

}
