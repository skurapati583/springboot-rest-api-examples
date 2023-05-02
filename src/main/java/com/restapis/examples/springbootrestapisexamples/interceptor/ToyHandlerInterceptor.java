package com.restapis.examples.springbootrestapisexamples.interceptor;

import jakarta.servlet.http.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class ToyHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("In preHandle():");
        log.info("The request URI is: " + request.getRequestURI());
        log.info("The request Method is: " + request.getMethod());
        log.info("The request ID is: " + request.getRequestId());
        log.info("The server name is: " + request.getServerName());
        log.info("The auth type is: " + request.getAuthType());
        log.info("The objecthandler is: {}", handler);
        log.info("The host name is: {}", request.getRemoteHost());

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("In postHandle():");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("In afterCompletion():");
        log.info("The status code is: " + response.getStatus());
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
