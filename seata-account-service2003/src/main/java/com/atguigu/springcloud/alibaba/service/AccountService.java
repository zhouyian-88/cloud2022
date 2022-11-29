package com.atguigu.springcloud.alibaba.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-11-29-15:51
 */

public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
