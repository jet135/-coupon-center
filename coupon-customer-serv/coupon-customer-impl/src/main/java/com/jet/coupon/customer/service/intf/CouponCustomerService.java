package com.jet.coupon.customer.service.intf;


import com.jet.coupon.calculation.api.beans.ShoppingCart;
import com.jet.coupon.calculation.api.beans.SimulationOrder;
import com.jet.coupon.calculation.api.beans.SimulationResponse;
import com.jet.coupon.customer.api.beans.RequestCoupon;
import com.jet.coupon.customer.api.beans.SearchCoupon;
import com.jet.coupon.customer.dao.entity.Coupon;
import com.jet.coupon.template.api.beans.CouponInfo;

import java.util.List;

// 用户对接服务
public interface CouponCustomerService {

    // 领券接口
    Coupon requestCoupon(RequestCoupon request);

    // 核销优惠券
    ShoppingCart placeOrder(ShoppingCart info);

    // 优惠券金额试算
    SimulationResponse simulateOrderPrice(SimulationOrder order);

    void deleteCoupon(Long userId, Long couponId);

    // 查询用户优惠券
    List<CouponInfo> findCoupon(SearchCoupon request);
}
