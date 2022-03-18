package com.at.cache;

import com.at.cache.bean.Employee;
import com.at.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot09CacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void contextLoads() {
        Employee employee = employeeMapper.getEmployeeById(1);
        System.out.println(employee);
    }

}
