package com.example.hrmanagementb9.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponce {
    private String message;
    private Boolean success;
    private Object object;

    public ApiResponce(String message, Boolean success){
        this.message=message;
        this.success=success;
    }
}
