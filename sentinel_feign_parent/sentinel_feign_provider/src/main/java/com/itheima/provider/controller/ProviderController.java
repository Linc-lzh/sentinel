package com.itheima.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @GetMapping("hello")
    public String hello(){
        return "Hello Sentinel!";
    }

}
