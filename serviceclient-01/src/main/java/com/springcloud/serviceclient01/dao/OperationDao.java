package com.springcloud.serviceclient01.dao;

import com.springcloud.serviceclient01.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 继承JpaRepository，第二个泛型参数为User类主键的类型
 *
 * @author Holley
 * @create 2018-07-03 14:38
 **/

public interface OperationDao extends JpaRepository<Operation,Long> {

}
