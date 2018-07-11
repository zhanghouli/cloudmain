package com.springcloud.serviceclient01.service.impl;

import com.springcloud.serviceclient01.aop.serverLog;
import com.springcloud.serviceclient01.dao.UserDao;
import com.springcloud.serviceclient01.model.User;
import com.springcloud.serviceclient01.service.Helloservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-07-03 14:33
 **/
@Service("helloservice")
public class HelloServiceImpl implements Helloservice{

    @Autowired
    private UserDao userDao;

    @serverLog(comment = "根据id查询用户")
    @Override
    public User getUserByid(Long id) {
        return userDao.getOne(id);
    }
    @Override
    public String findByUid(Long id) {
        return userDao.findByaa(id);
    }

    @Override
    public String findByUser(Long id, String name) {
       return userDao.findUser(id,name);
    }
}
