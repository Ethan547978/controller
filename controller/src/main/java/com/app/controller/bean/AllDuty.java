package com.app.controller.bean;

import java.util.List;

public class AllDuty {

    private int dutyNum;
    private String dutyContent;
    private List<DutyWeekday> dutyWeekdays;

    public int getDutyNum() {
        return dutyNum;
    }

    public void setDutyNum(int dutyNum) {
        this.dutyNum = dutyNum;
    }

    public String getDutyContent() {
        return dutyContent;
    }

    public void setDutyContent(String dutyContent) {
        this.dutyContent = dutyContent;
    }

    public List<DutyWeekday> getDutyWeekdays() {
        return dutyWeekdays;
    }

    public void setDutyWeekdays(List<DutyWeekday> dutyWeekdays) {
        this.dutyWeekdays = dutyWeekdays;
    }

}
