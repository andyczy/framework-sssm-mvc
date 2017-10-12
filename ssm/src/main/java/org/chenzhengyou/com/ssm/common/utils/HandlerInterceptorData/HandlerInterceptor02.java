package org.chenzhengyou.com.ssm.common.utils.HandlerInterceptorData;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by czy on 2016/11/5.
 */
public class HandlerInterceptor02 implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        System.out.println("HandlerInterceptor2...postHandle");

        return true;
    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("HandlerInterceptor2...postHandle");
    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

        System.out.println("HandlerInterceptor2...afterCompletion");
    }
}
