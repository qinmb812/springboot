package com.at.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一、搭建基本环境
 * 1、导入数据库文件 创建出department和employee表
 * 2、创建JavaBean封装数据
 * 3、整合Mybatis操作数据库
 *      1.配置数据源信息
 *      2.使用注解版的Mybatis：
 *          1）、@MapperScan指定需要扫描的mapper接口所在的包
 * 二、快速体验缓存
 *      步骤：
 *          1、开启基于注解的缓存     @EnableCaching
 *          2、标注缓存注解即可
 *              @Cacheable
 *              @CacheEvict
 *              @CachePut
 * 默认使用的是ConcurrentMapCacheManager==ConcurrentMapCache；将数据保存在ConcurrentMap<String, Cache>中；
 * 开发中使用缓存中间件：redis、memcached、ehcache
 * 三、整合redis作为缓存
 * Redis是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。
 * 1、安装redis；
 * 2、引入redis的starter；
 * 3、配置redis；
 */
@MapperScan("com.at.cache.mapper")
@SpringBootApplication
@EnableCaching
public class Springboot09CacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot09CacheApplication.class, args);
    }
}
