package com.at.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、引入SpringSecurity；
 * 2、编写SpringSecurity的配置类；
 *      @EnableWebSecurity      extends WebSecurityConfigurerAdapter
 * 3、控制请求的访问权限
 */
@SpringBootApplication
public class Springboot13SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot13SecurityApplication.class, args);
    }
}
