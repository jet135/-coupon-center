package com.jet.coupon.customer.config;

import lombok.Getter;
import lombok.Setter;

/**
 * @author spike
 * @Description
 */
@Getter
@Setter
public class DistributedContext {

    public static final ThreadLocal<DistributedContext> threadLocal = new ThreadLocal<>();

    private String trafficValue;

    public static DistributedContext getDistributedContext() {
        DistributedContext distributedContext = DistributedContext.threadLocal.get();
        if(distributedContext == null) {
            threadLocal.set(new DistributedContext());
            return threadLocal.get();
        }
        return distributedContext;
    }

    public static void setTrafficHeader(String trafficValue) {
        getDistributedContext().setTrafficValue(trafficValue);
    }

    public static String getTrafficHeaderValue() {
        return getDistributedContext().getTrafficValue();
    }
}
