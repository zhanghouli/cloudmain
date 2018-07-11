package com.springcloud.serviceclient01.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 操作表的实体类
 *
 * @author Holley
 * @create 2018-06-05 14:12
 **/
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long opid;
    private Long sid;
    private Long oid;
    private Long pid;
    private Long uid;
    private String account;
    private String content;
    private Date created;
    @Transient
    private String orderCode;
    @Transient
    private String pname;
    @Transient
    private String sname;

    public Long getOpid() {
        return opid;
    }

    public void setOpid(Long opid) {
        this.opid = opid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "opid=" + opid +
                ", sid=" + sid +
                ", oid=" + oid +
                ", pid=" + pid +
                ", uid=" + uid +
                ", account='" + account + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", orderCode='" + orderCode + '\'' +
                ", pname='" + pname + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }
}
