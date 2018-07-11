package com.springcloud.serviceclient01.dao;

import com.springcloud.serviceclient01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * 继承JpaRepository，第二个泛型参数为User类主键的类型
 *
 * @author Holley
 * @create 2018-07-03 14:38
 **/

public interface UserDao extends JpaRepository<User,Long> {

    /**
      * @Author holley
      * @Description 注意：使用jpa时，User不是数据库中的表名，而是实体类的类名
      * @Date 2018/7/3 16:12
      * @Param
      * @return
      */
    @Transactional(timeout = 10)
    @Query("select name from User where uid = ?1")
    String findByaa(Long uid);
    @Transactional(timeout = 10)
    @Query("select password from User where uid = ?1 and name = ?2")
    String findUser(Long uid,String name);
}
