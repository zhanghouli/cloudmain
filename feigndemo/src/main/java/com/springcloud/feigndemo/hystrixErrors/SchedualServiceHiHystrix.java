package com.springcloud.feigndemo.hystrixErrors;

import com.springcloud.feigndemo.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * SchedualServiceHi接口中方法远程调用出错时执行下面对应的方法
 *
 * @author Holley
 * @create 2018-06-22 10:35
 **/
@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi {
    @Override
    public String sayHiFromClientone(String name) {
        return "sorry," + name + ",this is error!";
    }
}
