package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.text.TabExpander;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-11-23-11:25
 */
@Configuration
public class ApplicationContextBean {


    @Resource
    private RestTemplate restTemplate;

    @Bean //注册到容器中
    @LoadBalanced //负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
