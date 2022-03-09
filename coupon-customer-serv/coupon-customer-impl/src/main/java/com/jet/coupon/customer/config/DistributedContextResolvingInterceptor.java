package com.jet.coupon.customer.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.jet.coupon.customer.constant.Constant.TRAFFIC_VERSION;

/**
 * @author spike
 * @Description
 */
public class DistributedContextResolvingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String trafficValue = request.getHeader(TRAFFIC_VERSION);
        DistributedContext.setTrafficHeader(trafficValue);
        return true;
    }
}
