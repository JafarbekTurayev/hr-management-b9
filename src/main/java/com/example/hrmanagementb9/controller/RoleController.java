package com.example.hrmanagementb9.controller;

import com.example.hrmanagementb9.entity.Role;
import com.example.hrmanagementb9.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(roleService.getRole());
    }
    @PostMapping
    public HttpEntity<?> addRole(@RequestParam Role roleName){
        return  ResponseEntity.ok().body(roleService.addRole(roleName));
    }
}
