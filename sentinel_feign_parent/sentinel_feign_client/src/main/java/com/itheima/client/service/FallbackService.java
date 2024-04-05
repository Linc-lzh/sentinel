package com.itheima.client.service;

import com.itheima.client.agent.FeignAgent;
import org.springframework.stereotype.Component;

//限流或者降级的回调类
@Component
public class FallbackService implements FeignAgent {
    //限流和降级的处理
    @Override
    public String hello() {
        return "系统繁忙，请稍候";
    }
}
