package com.springcloud.feigndemo.service;

import com.springcloud.feigndemo.hystrixErrors.SchedualServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-06-21 17:36
 **/
@Component
@FeignClient(value = "serviceclient-01",fallback = SchedualServiceHiHystrix.class)
public interface SchedualServiceHi {

    @GetMapping(value = "/hi")
    String sayHiFromClientone(@RequestParam(value = "name")String name);
}
