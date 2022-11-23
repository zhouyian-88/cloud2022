package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-11-23-10:28
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public String paymentZk(){
        return "springCloud with zookeeper" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
