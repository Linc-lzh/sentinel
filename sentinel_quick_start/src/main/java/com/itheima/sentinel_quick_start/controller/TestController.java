package com.itheima.sentinel_quick_start.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("hello")
    public String hello(){
        //使用限流规则
        try(Entry entry = SphU.entry("Hello")){//限流入口
            return "Hello Sentinel!";//被保护的资源
        } catch (BlockException e) {
            e.printStackTrace();
            return "系统繁忙，请稍候";//被限流或者被降级的操作处理
        }

    }

    //定义限流规则
    //@PostConstruct : 当前类的构造函数执行之后执行
    /*@PostConstruct
    public void initFlowRules(){
        //1.创建存放限流规则的集合
        List<FlowRule> rules = new ArrayList<>();
        //2.创建限流规则
        FlowRule rule = new FlowRule();
        //定义资源，表示Sentinel会对哪个资源生效
        rule.setResource("Hello");
        //定义限流规则类型,RuleConstant.FLOW_GRADE_QPS:QPS限流类型
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //定义了QPS每秒能通过的请求个数
        rule.setCount(2);
        //3.将限流规则存放到集合中
        rules.add(rule);
        //4.加载限流规则
        FlowRuleManager.loadRules(rules);
    }*/
}
