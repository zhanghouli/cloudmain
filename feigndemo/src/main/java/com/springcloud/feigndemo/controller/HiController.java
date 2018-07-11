package com.springcloud.feigndemo.controller;

import com.springcloud.feigndemo.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-06-21 17:40
 **/
@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name,@RequestHeader("token") String token){
        System.out.println("first token :"+token);
        return schedualServiceHi.sayHiFromClientone(name);
    }




}
