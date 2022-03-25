package com.example.hrmanagementb9.component;

import com.example.hrmanagementb9.entity.Company;
import com.example.hrmanagementb9.entity.Employee;
import com.example.hrmanagementb9.entity.Role;
import com.example.hrmanagementb9.repository.CompanyRepository;
import com.example.hrmanagementb9.repository.EmployeeRepository;
import com.example.hrmanagementb9.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class Dataloader implements CommandLineRunner {

    @Value("${spring.sql.init.mode}")
    private String mode;
    final PasswordEncoder passwordEncoder;
    final RoleRepository roleRepository;
    final CompanyRepository companyRepository;
    final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        if (mode.equals("always")) {

            Role director = roleRepository.save(new Role(1, "DIRECTOR"));
            Role manager = roleRepository.save(new Role(2, "MANAGER"));
            Role user = roleRepository.save(new Role(3, "USER"));

            Employee jafar = employeeRepository.save(new Employee("jafar", passwordEncoder.encode("12345"), "jafarbek1997@gmail.com", director, true));
            companyRepository.save(new Company(1, "PDP", jafar));

        }
    }

}
