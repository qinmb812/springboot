package com.at.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 搭建基本环境
 * 1、导入数据库文件 创建出department和employee表
 * 2、创建JavaBean封装数据
 * 3、整合Mybatis操作数据库
 *      1.配置数据源信息
 *      2.使用注解版的Mybatis：
 *          1）、@MapperScan指定需要扫描的mapper接口所在的包
 */
@SpringBootApplication
public class Springboot09CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09CacheApplication.class, args);
    }

}
