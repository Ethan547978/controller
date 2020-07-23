package com.app.controller.bean;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class DutyBean implements Comparator<DutyBean>, Serializable {

    private Integer dutyNum;
    private String dutyContent;
    private List<DutyWeekdays> dutyWeekdays;

    public Integer getDutyNum() {
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

    public List<DutyWeekdays> getDutyWeekdays() {
        return dutyWeekdays;
    }

    public void setDutyWeekdays(List<DutyWeekdays> dutyWeekdays) {
        this.dutyWeekdays = dutyWeekdays;
    }

    @Override
    public int compare(DutyBean o1, DutyBean o2) {
        return o1.dutyNum.compareTo(o2.dutyNum);
    }
}
