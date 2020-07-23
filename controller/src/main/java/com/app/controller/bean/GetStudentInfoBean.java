package com.app.controller.bean;


import java.io.Serializable;

public class GetStudentInfoBean implements Serializable {
    private StudentInfo data;

    public StudentInfo getData() {
        return data;
    }

    public void setData(StudentInfo data) {
        this.data = data;
    }
}
