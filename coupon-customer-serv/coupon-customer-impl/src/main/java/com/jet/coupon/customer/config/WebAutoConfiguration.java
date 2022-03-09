package com.jet.coupon.customer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author spike
 * @Description
 */
@Configuration
public class WebAutoConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new DistributedContextResolvingInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/actuator/**", "/error", "/favicon.ico");
    }
}
