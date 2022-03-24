package com.example.hrmanagementb9.service;

import com.example.hrmanagementb9.dto.ApiResponce;
import com.example.hrmanagementb9.dto.TaskDto;
import com.example.hrmanagementb9.entity.Task;
import com.example.hrmanagementb9.repository.EmployeeRepository;
import com.example.hrmanagementb9.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public ApiResponce addService(@RequestBody TaskDto taskDto) {
        Task task = new Task();
        if (taskRepository.existsByName(taskDto.getName())) return new ApiResponce("This task exist", false);
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setEmployeeList(employeeRepository.findAll());
        return new ApiResponce();
    }

}
