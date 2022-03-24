package com.example.hrmanagementb9.service;

import com.example.hrmanagementb9.dto.ApiResponce;
import com.example.hrmanagementb9.entity.Role;
import com.example.hrmanagementb9.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public ApiResponce getRole(){
        List<Role> roles = roleRepository.findAll();
        return new ApiResponce("mana",true,roles);
    }
    public ApiResponce addRole(@RequestBody Role role){
        if(roleRepository.existByName(role.getName())){
            return new ApiResponce("This role exist",false);
        }
        Role role1 = new Role();
        role1.setName(role.getName());
        Role savedRole = roleRepository.save(role1);
        return new ApiResponce("Role added",true,savedRole);
    }
}

