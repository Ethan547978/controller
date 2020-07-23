package com.app.controller.bean;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class ClassInfo  implements Serializable {
    @Expose
    private int type;//类型：1.小学，2.初中，3.高中，4.大学
    @Expose
    private int userId;
    @Expose
    private int grade;
    @Expose
    private int classNum;
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "type=" + type +
                ", userId=" + userId +
                ", grade=" + grade +
                ", classNum=" + classNum +
                ", name='" + name + '\'' +
                '}';
    }
}
