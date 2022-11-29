package com.atguigu.springcloud.alibaba.contoller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-11-29-14:50
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;
    @GetMapping("/order/create")
    public CommonResult create(Order order){
       orderService.create(order);
       return new CommonResult(200,"订单创建成功");
    }
}
