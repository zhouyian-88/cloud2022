package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-11-29-11:55
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    /**
     * 创建订单---->调用库存服务扣减库存--->调用账户服务扣减账户余额---->修改订单状态
     * 下订单--->减库存--->减余额--->改状态
     */
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    //rollbackFor = Exception.class表示对任意异常都进行回滚
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-----开始新建订单");
        //1.新建订单
        orderDao.create(order);
        log.info("----->订单微服务开始调用库存，做扣减count");
        //2.扣减库存
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        log.info("----->订单微服务开始调用账户，开始做扣减money");
        //3.扣减账户
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----->订单微服务开始调用账户，开始做扣减end");

        //4.修改订单状态，从0-->1
        log.info("------>修改订单状态开始");
        //5、更新状态
        orderDao.update(order.getUserId(),0);
        log.info("------>修改订单状态结束");

        log.info("----->下订单结束");


    }
}
