package com.springcloud.serviceclient01.service;

import com.springcloud.serviceclient01.model.User;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-07-03 14:34
 **/
public interface Helloservice {

    User getUserByid(Long id);

    String findByUid(Long id);

    String findByUser(Long id,String name);

}
