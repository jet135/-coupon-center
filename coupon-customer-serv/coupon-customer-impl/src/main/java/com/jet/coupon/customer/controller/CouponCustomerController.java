package com.jet.coupon.customer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jet.coupon.calculation.api.beans.ShoppingCart;
import com.jet.coupon.calculation.api.beans.SimulationOrder;
import com.jet.coupon.calculation.api.beans.SimulationResponse;
import com.jet.coupon.customer.api.beans.RequestCoupon;
import com.jet.coupon.customer.api.beans.SearchCoupon;
import com.jet.coupon.customer.dao.entity.Coupon;
import com.jet.coupon.customer.service.intf.CouponCustomerService;
import com.jet.coupon.template.api.beans.CouponInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("coupon-customer")
public class CouponCustomerController {

    @Autowired
    private CouponCustomerService customerService;

    @PostMapping("requestCoupon")
    public Coupon requestCoupon(@Valid @RequestBody RequestCoupon request) {
        return customerService.requestCoupon(request);
    }

    // 用户删除优惠券
    @DeleteMapping("deleteCoupon")
    public void deleteCoupon(@RequestParam("userId") Long userId,
                                       @RequestParam("couponId") Long couponId) {
        customerService.deleteCoupon(userId, couponId);
    }

    // 用户模拟计算每个优惠券的优惠价格
    @PostMapping("simulateOrder")
    @SentinelResource(value = "simulate", blockHandler = "simulate_block")
    public SimulationResponse simulate(@Valid @RequestBody SimulationOrder order) {
        return customerService.simulateOrderPrice(order);
    }

    public SimulationResponse simulate_block(SimulationOrder order, BlockException e){
        System.out.println(e.getMessage());
        return SimulationResponse.builder().bestCouponId(11L).build();
    }

    // ResponseEntity - 指定返回状态码 - 可以作为一个课后思考题
    @PostMapping("placeOrder")
    public ShoppingCart checkout(@Valid @RequestBody ShoppingCart info) {
        return customerService.placeOrder(info);
    }


    // 实现的时候最好封装一个search object类
    @PostMapping("findCoupon")
    public List<CouponInfo> findCoupon(@Valid @RequestBody SearchCoupon request) {
        return customerService.findCoupon(request);
    }

}
