package com.springcloud.ribbondemo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 通过restTemplate调用另外一个服务api，如果调用失败则会启动断路器机制，调用hiError方法
 *
 * @author Holley
 * @create 2018-06-21 17:06
 **/
@Service("helloService")
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://serviceclient-01/hi?name=" + name,String.class);
    }

    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService(Long id){
        return restTemplate.getForObject("http://serviceclient-01/hello/" + id,String.class);
    }
    public String hiError(String name){
        return "hi," + name + ",i am Hystrix";
    }
    public String helloError(Long id){
        return "hi," + id + ",i am Hystrix";
    }
}
