package com.springcloud.serviceclient01.aop;

import java.lang.annotation.*;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-07-03 14:23
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface serverLog {

    public String comment() default "";
}
