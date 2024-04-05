package com.itheima.sentinel_quick_start.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestBooleanController {

    @GetMapping("boolean")
    public boolean hello(){
        //使用限流规则
        if(SphO.entry("Sentinel_Boolean")){//限流入口
            try {
                //被保护的资源
                System.out.println("Hello Sentinel!");
                return true;
            }finally {
                SphO.exit();//限流的出口
            }
        }else{
            //被限流或降级的处理
            System.out.println("系统繁忙，请稍候");
            return false;
        }

    }


}
