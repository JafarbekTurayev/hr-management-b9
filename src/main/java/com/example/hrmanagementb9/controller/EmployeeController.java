package com.example.hrmanagementb9.controller;

import com.example.hrmanagementb9.dto.EmployeeDTO;
import com.example.hrmanagementb9.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public HttpEntity<?> getAll(){
       return ResponseEntity.ok().body(employeeService.getAll());
    }

    @PostMapping
    public HttpEntity<?> add( @Valid @RequestBody EmployeeDTO dto){
        return ResponseEntity.ok().body(employeeService.add(dto));
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable UUID id, @Valid  @RequestBody EmployeeDTO dto){
        return ResponseEntity.ok().body(employeeService.edit(id, dto));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id){
        return ResponseEntity.ok().body(employeeService.delete(id));
    }

}
