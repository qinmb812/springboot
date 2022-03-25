package com.at.cache.controller;

import com.at.cache.bean.Department;
import com.at.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDepartmentById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id);
    }
}
