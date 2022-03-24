package com.example.hrmanagementb9.service;

import com.example.hrmanagementb9.dto.ApiResponce;
import com.example.hrmanagementb9.entity.Company;
import com.example.hrmanagementb9.entity.Employee;
import com.example.hrmanagementb9.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public ApiResponce getAll(){
        List<Company> all = companyRepository.findAll();
        return new ApiResponce("success", true, all);
    }

    public ApiResponce add(String name){
        if (companyRepository.existsByName(name)){
            return new ApiResponce("name already exist", false);
        }
        Company company = new Company();
        company.setName(name);
        companyRepository.save(company);
        return new ApiResponce("added", true, company);
    }

    public ApiResponce edit(UUID id, String name){
        Optional<Company> company = companyRepository.findById(id);
        if(company.isEmpty()){
            return new ApiResponce("employee not found!", false);
        }
        Company comp = company.get();
        comp.setName(name);
        companyRepository.save(comp);
        return new ApiResponce("edited", true, comp);
    }

    public ApiResponce delete(UUID id){
        Optional<Company> company = companyRepository.findById(id);
        if(company.isEmpty()){
            return new ApiResponce("employee not found!", false);
        }
        companyRepository.delete(company.get());
        return new ApiResponce("deleted", true);
    }
}
