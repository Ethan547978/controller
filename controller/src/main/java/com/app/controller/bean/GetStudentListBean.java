package com.app.controller.bean;


import java.io.Serializable;
import java.util.List;

public class GetStudentListBean implements Serializable {
    private int current;
    private int size;
    private List<StudentInfo> records;

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

    public List<StudentInfo> getRecords() {
        return records;
    }

    public void setRecords(List<StudentInfo> records) {
        this.records = records;
    }
}
