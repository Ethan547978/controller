package com.app.controller.bean;

import java.util.List;

public class GetVisitorListBean {
    private int current;
    private int size;
    private List<VisitorInfo> records;

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

    public List<VisitorInfo> getRecords() {
        return records;
    }

    public void setRecords(List<VisitorInfo> records) {
        this.records = records;
    }
}
