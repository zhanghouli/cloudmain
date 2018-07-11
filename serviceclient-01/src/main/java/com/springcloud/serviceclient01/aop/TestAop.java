package com.springcloud.serviceclient01.aop;

import com.springcloud.serviceclient01.dao.OperationDao;
import com.springcloud.serviceclient01.model.Operation;
import com.springcloud.serviceclient01.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-07-03 16:57
 **/
@Aspect
@Order(2)
@Component
public class TestAop {

    @Autowired
    private OperationDao operationDao;
    /**
      * @Author holley
      * @Description 第一种设置切点的方式
      * 定义切点（添加severLog的方法），log是参数（该切点的serverLog注解的实例变量）
      * @Date 2018/7/3 17:09
      * @Param
      * @return
      */
    @Pointcut("@annotation(log)")
    public void severLog(serverLog log){ }

    /**
      * @Author holley
      * @Description JoinPoint joinPoint参数在所有类型通知中都可直接调用，表示和切面的连接点，可以通过词参数获取切面方法的参数等
      * @Date 2018/7/3 17:55
      * @Param
      * @return
      */
    @After("severLog(log)")
    public void rightback(JoinPoint joinPoint, serverLog log){
        // 可以在此处通过 获取token得到当前登陆人的信息，也可以通过缓存获取，然后存入操作记录
        Operation operation = new Operation();
        operation.setContent(log.comment());
        operation.setCreated(new Date());
        operationDao.save(operation);
        System.out.println("切面的所有参数:" + Arrays.toString(joinPoint.getArgs()));
    }

    /**
      * @Author holley
      * @Description returning 定义该切面（添加了severLog注解的方法）的返回结果
      * @Date 2018/7/3 17:41
      * @Param
      * @return
      */
    /*@AfterReturning(returning = "u", pointcut = "severLog(log)")
    public void endback(JoinPoint joinPoint,User u,serverLog log){
        System.out.println(u.toString()+"-----------------------"+log.comment());
        System.out.println("切面的所有参数:" + Arrays.toString(joinPoint.getArgs()));
        // 通过连接点获取方法，通过方法获取注解
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        serverLog logT =  method.getAnnotation(serverLog.class);
        System.out.println("注解的参数:" + logT.comment());
    }*/

    /**
      * @Author holley
      * @Description 第二种设置切点的方式
      * 第一个星号：表示返回类型，*号表示所有类型
      *  第二个星号：表示设置为切点的类名，*号表示所有的类
      *  第三个星号：表示设置为切点的类的方法名，*号表示该类中所有的方法
      *  括弧里表示方法的参数，两个点表示任何参数
      * @Date 2018/7/3 17:48
      * @Param
      * @return
      */
    /*@Pointcut("execution(* com.springcloud.serviceclient01.service.impl..*.*(..))")
    public void severTest(){
    }
    @After("severTest()")
    public void rightback(JoinPoint joinPoint){
        // 通过连接点获取方法，通过方法获取注解
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        serverLog logT =  method.getAnnotation(serverLog.class);
        System.out.println("注解的参数:" + logT.comment());
        Operation operation = new Operation();
        operation.setContent(logT.comment());
        operation.setCreated(new Date());
        operationDao.save(operation);
    }*/

}
