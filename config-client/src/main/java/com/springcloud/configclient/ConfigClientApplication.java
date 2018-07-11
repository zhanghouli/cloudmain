package com.springcloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${foo}")
	String foo;
	/**
	  * @Author holley
	  * @Description 返回从配置中心读取的foo变量的值
	  *  远程仓库https://github.com/xxx/ 中有个文件config-client-dev.properties文件中有一个属性： foo version 3
	  * @Date 2018/6/22 16:57
	  * @Param
	  * @return
	  */
	@RequestMapping(value = "/hi")
	public String hi(){
		return foo;
	}
}
