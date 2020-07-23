package com.app.controller.bean;


import java.io.Serializable;

public class MyGradeClassBean implements Serializable {

    private int type;//年级类型：1.小学，2.初中，3.高中，4.大学
    private int grade;
    private int classNum;
    private boolean isChecked;//本地字段，仅用于判断是否被checkbox选中

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

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
