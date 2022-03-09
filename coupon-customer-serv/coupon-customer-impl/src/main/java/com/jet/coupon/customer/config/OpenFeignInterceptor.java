package com.jet.coupon.customer.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

import static com.jet.coupon.customer.constant.Constant.TRAFFIC_VERSION;

/**
 * @author spike
 * @Description feign请求拦截器
 *  标记@Configuration时作用于全部feignclient
 *  需要用于某个feignClient时，把@Configuration去掉，在@FeignClient中配置configuration指定Interceptor
 */
@Configuration
public class OpenFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 从请求上下文中获取
        requestTemplate.header(TRAFFIC_VERSION, DistributedContext.getTrafficHeaderValue());
        requestTemplate.header("SentinelSource", "coupon-customer-serv");
    }
}
