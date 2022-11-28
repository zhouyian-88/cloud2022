package com.atguigu.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-11-28-19:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9005{
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9005.class, args);
    }
}
