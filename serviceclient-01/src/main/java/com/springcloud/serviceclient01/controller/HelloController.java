package com.springcloud.serviceclient01.controller;

import com.springcloud.serviceclient01.model.User;
import com.springcloud.serviceclient01.service.Helloservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-07-03 15:12
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Helloservice helloservice;

    @GetMapping("/{sid}")
    public String Hello(@PathVariable("sid") Long sid){
        User u = helloservice.getUserByid(sid);
        return u.toString();
    }

    @GetMapping("/test/{sid}")
    public String test1(@PathVariable("sid") Long sid){
        String name = helloservice.findByUid(sid);
        return name;
    }
    /**
      * @Author holley
      * @Description 注意：使用spring注解将变量直接用/加在地址栏后时，不能传字符串，如：localhost:18762/hello/name/2/川普
      * 正确如下
      *  localhost:18762/hello/name/2?name=川普
      * @Date 2018/7/3 16:19
      * @Param
      * @return
      */
    @GetMapping("/name/{sid}")
    public String test2(@PathVariable("sid") Long sid,@RequestParam("name")String name){
        String p = helloservice.findByUser(sid,name);
        return p;
    }

    /**
      * @Author holley
      * @Description 证明不能传字符串格式的参数
      * @Date 2018/7/3 16:23
      * @Param
      * @return
      */
    /*@GetMapping("/a/{name}")
    public String test3(@PathVariable("name")String name){
        System.out.print(name + "测试成功--------------");
        return name;
    }*/
}
