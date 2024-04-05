package com.itheima.client.controller;

import com.itheima.client.agent.FeignAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private FeignAgent feignAgent;

    @GetMapping("hello")
    public String hello(){
        return feignAgent.hello();
    }
}
