package com.app.controller.event;

public class ConrrectHomeworkEvent {

    private int id;
    private int status;//状态：0.打回，1.待批改，2.已批改
    public ConrrectHomeworkEvent(int status, int id){
        this.status = status;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
