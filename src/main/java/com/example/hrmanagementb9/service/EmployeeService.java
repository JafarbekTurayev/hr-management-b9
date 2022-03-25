package com.example.hrmanagementb9.service;

import com.example.hrmanagementb9.dto.ApiResponce;
import com.example.hrmanagementb9.dto.EmployeeDTO;
import com.example.hrmanagementb9.entity.Employee;
import com.example.hrmanagementb9.entity.TurniKet;
import com.example.hrmanagementb9.repository.EmployeeRepository;
import com.example.hrmanagementb9.repository.TurniKetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    TurniKetRepository turniKetRepository;

    public ApiResponce getAll() {
        List<Employee> all = employeeRepository.findAll();
        return new ApiResponce("success", true, all);
    }

    public ApiResponce add(EmployeeDTO dto) {
        if (employeeRepository.existsByUsername(dto.getUsername())) {
            return new ApiResponce("username already exist", false);
        }
        Employee employee = new Employee();
        employee.setUsername(dto.getUsername());
        employee.setPassword(dto.getPassword());
        Employee save = employeeRepository.save(employee);

        TurniKet turniKet = new TurniKet();
        turniKet.setEmployee(save);
        turniKetRepository.save(turniKet);
        return new ApiResponce("added", true, employee);
    }

    public ApiResponce edit(UUID id, EmployeeDTO dto) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            return new ApiResponce("employee not found!", false);
        }
        Employee emp = employee.get();
        emp.setUsername(dto.getUsername());
        emp.setPassword(dto.getPassword());
        emp.setEmail(dto.getEmail());
        emp.setRoles(dto.getRole());
        emp.setActive(dto.getActive());
        employeeRepository.save(emp);
        return new ApiResponce("edited", true, emp);
    }

    public ApiResponce delete(UUID id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            return new ApiResponce("employee not found!", false);
        }
        employeeRepository.delete(employee.get());
        return new ApiResponce("deleted", true);
    }

}
