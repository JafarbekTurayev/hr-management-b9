package com.example.hrmanagementb9.controller;

import com.example.hrmanagementb9.dto.EmployeeDTO;
import com.example.hrmanagementb9.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(companyService.getAll());
    }

    @PostMapping
    public HttpEntity<?> add(@RequestParam String name){
        return ResponseEntity.ok().body(companyService.add(name));
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable UUID id,  @RequestParam String name){
        return ResponseEntity.ok().body(companyService.edit(id, name));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id){
        return ResponseEntity.ok().body(companyService.delete(id));
    }
}
