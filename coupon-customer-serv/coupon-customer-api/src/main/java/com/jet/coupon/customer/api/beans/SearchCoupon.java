package com.jet.coupon.customer.api.beans;

import com.jet.coupon.template.api.beans.CouponTemplateInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCoupon {

    @NotNull
    private Long userId;
    private Long shopId;
    private Integer couponStatus;

}
