package com.atguigu.springcloudalibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-11-28-19:14
 */

public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息1......CustomerBlockHandler");
    }

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息2......CustomerBlockHandler");
    }
}
