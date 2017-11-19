package com.yaoyou.infrastructure.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by song on 16/8/5.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    protected final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId =  (String)request.getSession().getAttribute("userId");
        if(userId == null){
            logger.info("Interceptor：跳转到login页面！");
            String returnUrl = request.getRequestURI();
            response.sendRedirect("/user/login?return="+returnUrl);
            return false;
        }else
            return true;
    }
}
