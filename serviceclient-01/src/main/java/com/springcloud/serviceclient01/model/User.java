package com.springcloud.serviceclient01.model;

import javax.persistence.*;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-07-03 14:34
 **/
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    private String name;

    private String password;

    @Column(name ="is_opt_required")
    private Integer isOptRequired;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsOptRequired() {
        return isOptRequired;
    }

    public void setIsOptRequired(Integer isOptRequired) {
        this.isOptRequired = isOptRequired;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", isOptRequired=" + isOptRequired +
                '}';
    }
}
