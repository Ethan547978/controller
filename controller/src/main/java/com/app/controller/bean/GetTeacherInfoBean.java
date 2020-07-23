package com.app.controller.bean;


import java.io.Serializable;

public class GetTeacherInfoBean implements Serializable {
    private TeacherInfo data;

    public TeacherInfo getData() {
        return data;
    }

    public void setData(TeacherInfo data) {
        this.data = data;
    }
}
