package com.app.controller.bean;

import java.io.Serializable;

public class JobBean implements Serializable
/**
 *  "userId": 23,
 *             "sno": "1232323232323232",
 *             "name": "C罗",
 *             "sex": 0,
 *             "job": "体育课代表"
 */
{
    private int userId;
    private int sex;
    private String sno;
    private String name;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    private String job;
    private String logo;
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
