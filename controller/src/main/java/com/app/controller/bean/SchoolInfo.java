package com.app.controller.bean;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class SchoolInfo implements Serializable {
    @Expose
    private int id;//学校id
    @Expose
    private String name;//学校名称
    @Expose
    private String address;// 学校地址
    @Expose
    private String masterName;//校长姓名
    @Expose
    private String masterMobile;// 校长电话

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterMobile() {
        return masterMobile;
    }

    public void setMasterMobile(String masterMobile) {
        this.masterMobile = masterMobile;
    }

    @Override
    public String toString() {
        return "SchoolInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", masterName='" + masterName + '\'' +
                ", masterMobile='" + masterMobile + '\'' +
                '}';
    }
}
