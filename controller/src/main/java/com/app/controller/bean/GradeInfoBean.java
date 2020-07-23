package com.app.controller.bean;

import java.io.Serializable;

public class GradeInfoBean implements Serializable {
    private int type;//类型：1.小学，2.初中，3.高中，4.大学
    private int grade;
    private String gradeName;

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
