package com.restapis.examples.springbootrestapisexamples.config;

import com.restapis.examples.springbootrestapisexamples.interceptor.ToyHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    ToyHandlerInterceptor toyHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(toyHandlerInterceptor);
    }
}
