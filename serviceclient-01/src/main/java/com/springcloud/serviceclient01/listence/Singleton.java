package com.springcloud.serviceclient01.listence;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 单例模式之防止利用反序列化恢复java对象
 *
 * @author Holley
 * @create 2018-07-05 9:49
 **/
public class Singleton implements Serializable{

    private static Singleton instance;
    private String name;
    private Singleton(String name){
        System.out.println("调用有参数的构造器");
        this.name = name;
    }
    public static Singleton getInstance(String name){
        // 只有当instance为空时才创建该对象
        if(instance == null){
            instance = new Singleton(name);
        }
        return instance;
    }
    /**
      * @Author holley
      * @Description 通过readResolve方法来使反序列化恢复的对象和用new关键字创建的对象是同一个
      * @Date 2018/7/5 10:03
      * @Param
      * @return
      */
    private Object readResolve()throws ObjectStreamException{
        return instance;
    }
}
