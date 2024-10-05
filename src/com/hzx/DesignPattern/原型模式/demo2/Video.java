package com.hzx.DesignPattern.原型模式.demo2;

import java.util.Date;

public class Video implements Cloneable {

    private String name;
    private Date createTime;

    public Video(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Object obj = super.clone();
        //实现深克隆
        Video v = (Video) obj;
        v.createTime = (Date) this.createTime.clone();

        return obj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
