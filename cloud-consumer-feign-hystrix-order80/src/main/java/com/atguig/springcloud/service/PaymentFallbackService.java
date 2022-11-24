package com.atguig.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-11-24-16:48
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "--PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--paymentInfo_TimeOut fall back-paymentInfo_TimeOut,o(╥﹏╥)o";
    }
}
