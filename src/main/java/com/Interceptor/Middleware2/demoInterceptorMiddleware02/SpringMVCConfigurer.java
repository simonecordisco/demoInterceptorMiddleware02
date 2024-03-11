package com.Interceptor.Middleware2.demoInterceptorMiddleware02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringMVCConfigurer implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringMVCConfigurer.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(monthInterceptor());
    }

    @Bean
    public HandlerInterceptor monthInterceptor() {
        return new MonthInterceptor();
    }
}
