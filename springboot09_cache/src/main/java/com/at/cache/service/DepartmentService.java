package com.at.cache.service;

import com.at.cache.bean.Department;
import com.at.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(value = "dept")
    public Department getDepartmentById(Integer id) {
        System.out.println("查询部门：" + id);
        return departmentMapper.getDepartmentById(id);
    }
}
