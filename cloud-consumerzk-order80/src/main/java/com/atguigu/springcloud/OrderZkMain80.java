package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-11-23-11:23
 */
@SpringBootApplication
@EnableDiscoveryClient //服务发现
public class OrderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class, args);
    }
}
