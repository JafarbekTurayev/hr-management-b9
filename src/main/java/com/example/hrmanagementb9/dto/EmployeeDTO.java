package com.example.hrmanagementb9.dto;

import com.example.hrmanagementb9.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String username;
    private String password;
    private String email;
    private Integer roleId;

    public EmployeeDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
