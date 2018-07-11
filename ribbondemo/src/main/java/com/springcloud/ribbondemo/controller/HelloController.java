package com.springcloud.ribbondemo.controller;

import com.springcloud.ribbondemo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-06-21 17:04
 **/
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }

    @RequestMapping("/gg")
    public String hello(@RequestParam Long id){
        System.out.println("i am ribbon----------" + id);
        return helloService.helloService(id);
    }
}
