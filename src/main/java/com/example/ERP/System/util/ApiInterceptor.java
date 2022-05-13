package com.example.ERP.System.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ApiInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        if (request.getMethod().equals("POST")) {
        //            try {
        //                System.out.println("Request: \n " + JsonUtils.toPretty(IOUtils.toString(request.getReader())));
        //            } catch (Exception e) {
        //            }
        //        }

        return true;
    }
}
