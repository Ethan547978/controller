package com.app.controller.bean;


import java.io.Serializable;

public class XuedouDetailBean implements Serializable {

    private int level;
    private String studentName;
    private int point;
    private int collectPoint;//待领取学豆值
    private int likeCount;//

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getCollectPoint() {
        return collectPoint;
    }

    public void setCollectPoint(int collectPoint) {
        this.collectPoint = collectPoint;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
