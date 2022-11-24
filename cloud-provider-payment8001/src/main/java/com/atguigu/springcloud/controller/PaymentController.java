package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.atguigu.springcloud.service.PaymentService;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-11-21-22:37
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;//用户服务发现
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);

        log.info("******插入结果{}", result);
        if(result > 0){
            return new CommonResult(200,"插入成功,返回结果"+result+"\t 服务端口："+serverPort,payment);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById( id);
        log.info("********查询结果:{}", payment);
        if(payment != null){
            return new CommonResult(200,"查询成功"+"\t 服务端口："+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录，查询ID:"+id,null);
        }

    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();//得到有多少个微服务应用
        for (String element : services) {
            log.info("*****element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");//根据微服务的名称，获取到里面的信息
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
