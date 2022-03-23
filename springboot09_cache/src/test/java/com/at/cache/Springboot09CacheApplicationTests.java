package com.at.cache;

import com.at.cache.bean.Employee;
import com.at.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Springboot09CacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;    // 操作k-v都是字符串的
    @Autowired
    RedisTemplate redisTemplate;    // 操作k-v都是对象的
    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;

    /**
     * Redis常见的五大数据类型
     *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *  stringRedisTemplate.opsForValue()【String（字符串）】
     *  stringRedisTemplate.opsForList()【List（列表）】
     *  stringRedisTemplate.opsForSet()【Set（集合）】
     *  stringRedisTemplate.opsForHash()【Hash（散列）】
     *  stringRedisTemplate.opsForZSet()【ZSet（有序集合）】
     */
    @Test
    public void test01() {
        // 给redis中保存数据
//        stringRedisTemplate.opsForValue().append("msg", "hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    // 测试保存对象
    @Test
    public void test02() {
        Employee employee = employeeMapper.getEmployeeById(1);
        // 默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
//        redisTemplate.opsForValue().set("emp-01",employee);
        // 1、将数据以json的方式保存
        //  （1）自己将对象转换为json
        //  （2）redisTemplate默认的序列化规则；改变默认的序列化规则
        empRedisTemplate.opsForValue().set("emp-01", employee);
    }

    @Test
    void contextLoads() {
        Employee employee = employeeMapper.getEmployeeById(1);
        System.out.println(employee);
    }

}
