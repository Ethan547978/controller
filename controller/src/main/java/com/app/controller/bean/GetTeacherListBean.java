package com.app.controller.bean;


import java.io.Serializable;
import java.util.List;

public class GetTeacherListBean implements Serializable {
    private int current;
    private int size;
    private List<TeacherInfo> records;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<TeacherInfo> getRecords() {
        return records;
    }

    public void setRecords(List<TeacherInfo> records) {
        this.records = records;
    }
}
