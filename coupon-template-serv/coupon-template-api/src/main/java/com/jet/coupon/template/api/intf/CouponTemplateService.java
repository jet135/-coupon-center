package com.jet.coupon.template.api.intf;


import com.jet.coupon.template.api.beans.CouponTemplateInfo;
import com.jet.coupon.template.api.beans.PagedCouponTemplateInfo;
import com.jet.coupon.template.api.beans.TemplateSearchParams;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@FeignClient(
        contextId = "CouponTemplateService",
        name = "coupon-template-serv",
        primary = false)
@RequestMapping("/couponTemplate")
public interface CouponTemplateService {

    // 创建优惠券模板
    @PostMapping("createTemplate")
    CouponTemplateInfo createTemplate(@RequestBody CouponTemplateInfo request);

    @PostMapping("cloneTemplate")
    CouponTemplateInfo cloneTemplate(@RequestParam("templateId") Long templateId);

    // 模板查询（分页）
    @PostMapping("search")
    PagedCouponTemplateInfo search(@RequestBody TemplateSearchParams request);

    // 通过模板ID查询优惠券模板
    @PostMapping("loadTemplateInfo")
    CouponTemplateInfo loadTemplateInfo(@RequestParam("id") Long id);

    // 让优惠券模板无效
    @PostMapping("deleteTemplate")
    void deleteTemplate(@RequestParam("id") Long id);

    // 批量查询
    // Map是模板ID，key是模板详情
    @PostMapping("getTemplateInfoMap")
    Map<Long, CouponTemplateInfo> getTemplateInfoMap(@RequestBody Collection<Long> ids);
}
