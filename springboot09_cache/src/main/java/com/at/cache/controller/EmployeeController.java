package com.at.cache.controller;

import com.at.cache.bean.Employee;
import com.at.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/emp/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }
}
