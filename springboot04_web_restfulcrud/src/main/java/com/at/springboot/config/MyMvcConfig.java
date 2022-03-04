package com.at.springboot.config;

import com.at.springboot.component.LoginHandlerInterceptor;
import com.at.springboot.component.MyLocaleResolver;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//@EnableWebMvc     // 所有SpringMVC的自动配置都失效
// 使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
@Configuration
// public class MyMvcConfig extends WebMvcConfigurerAdapter {   // @deprecated
public class MyMvcConfig implements WebMvcConfigurer {
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
            // 定制嵌入式的servlet容器相关的规则
            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(8083);
            }
        };
    }

    //public class MyMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        // 浏览器发送 /atguigu 请求来到 success
        registry.addViewController("/atguigu").setViewName("success");
    }

    // 所有的WebMvcConfigurer组件都会一起起作用
    @Bean   // 将组建注册在容器
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                WebMvcConfigurer.super.addInterceptors(registry);
                // 静态资源：    *.csc , *.js
                // SpringBoot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html", "/", "/user/login");
            }
        };
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
