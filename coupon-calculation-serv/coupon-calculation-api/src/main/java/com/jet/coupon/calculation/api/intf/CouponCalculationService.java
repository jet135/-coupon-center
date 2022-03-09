package com.jet.coupon.calculation.api.intf;

import com.jet.coupon.calculation.api.beans.ShoppingCart;
import com.jet.coupon.calculation.api.beans.SimulationOrder;
import com.jet.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
        contextId = "CouponCalculationService",
        name = "coupon-calculation-serv",
        primary = false)
@RequestMapping("/couponCalculation")
public interface CouponCalculationService {

    @PostMapping("/calculateOrderPrice")
    ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart cart);

    @PostMapping("/simulateOrder")
    SimulationResponse simulateOrder(@RequestBody SimulationOrder cart);
}
