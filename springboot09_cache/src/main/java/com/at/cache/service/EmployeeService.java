package com.at.cache.service;

import com.at.cache.bean.Employee;
import com.at.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public Employee getEmployeeById(Integer id) {
        System.out.println("查询" + id + "号员工");
        Employee employee = employeeMapper.getEmployeeById(id);
        return employee;
    }
}
