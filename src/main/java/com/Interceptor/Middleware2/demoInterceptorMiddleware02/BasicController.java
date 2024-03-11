package com.Interceptor.Middleware2.demoInterceptorMiddleware02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @GetMapping("/")
    public String welcome() {
        return "Benvenuto!";
    }
}

