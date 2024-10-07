package com.laoli.interceptor;

import com.laoli.service.IpCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WeiHanQiang
 * @date 2024/10/07 13:30
 **/
public class IpCounterInterceptor implements HandlerInterceptor {
    @Autowired
    private IpCounterService ipCounterService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ipCounterService.record();
        return true;
    }
}
