package com.at.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

//@EnableWebMvc     // 所有SpringMVC的自动配置都失效
// 使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
@Configuration
// public class MyMvcConfig extends WebMvcConfigurerAdapter {   // @deprecated
// public class MyMvcConfig implements WebMvcConfigurer {
public class MyMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        // 浏览器发送 /atguigu 请求来到 success
        registry.addViewController("/atguigu").setViewName("success");
    }
}
