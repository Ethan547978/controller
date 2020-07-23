package com.app.controller.bean;

import java.io.Serializable;

public class AttendanceConfigBean implements Serializable {
    private int id;
    private int schoolId;
    private String schoolName;
    private int late1From;
    private int late1To;
    private int late2;
    private int late3;
    private int early1From;
    private int early2;
    private int early1To;
    private int early3;
    private String type;
    private String morningEnterTime;
    private String morningOutTime;
    private String afternoonEnterTime;
    private String afternoonOutTime;
    private String eveningEnterTime;
    private String eveningOutTime;
    private String weekdays;
    private String createTime;
    private String updateTime;

    public int getId() {
        return id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(String weekdays) {
        this.weekdays = weekdays;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getLate1From() {
        return late1From;
    }

    public void setLate1From(int late1From) {
        this.late1From = late1From;
    }

    public int getLate1To() {
        return late1To;
    }

    public void setLate1To(int late1To) {
        this.late1To = late1To;
    }

    public int getLate2() {
        return late2;
    }

    public void setLate2(int late2) {
        this.late2 = late2;
    }

    public int getLate3() {
        return late3;
    }

    public void setLate3(int late3) {
        this.late3 = late3;
    }

    public int getEarly1From() {
        return early1From;
    }

    public void setEarly1From(int early1From) {
        this.early1From = early1From;
    }

    public int getEarly2() {
        return early2;
    }

    public void setEarly2(int early2) {
        this.early2 = early2;
    }

    public int getEarly1To() {
        return early1To;
    }

    public void setEarly1To(int early1To) {
        this.early1To = early1To;
    }

    public int getEarly3() {
        return early3;
    }

    public void setEarly3(int early3) {
        this.early3 = early3;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMorningEnterTime() {
        return morningEnterTime;
    }

    public void setMorningEnterTime(String morningEnterTime) {
        this.morningEnterTime = morningEnterTime;
    }

    public String getMorningOutTime() {
        return morningOutTime;
    }

    public void setMorningOutTime(String morningOutTime) {
        this.morningOutTime = morningOutTime;
    }

    public String getAfternoonEnterTime() {
        return afternoonEnterTime;
    }

    public void setAfternoonEnterTime(String afternoonEnterTime) {
        this.afternoonEnterTime = afternoonEnterTime;
    }

    public String getAfternoonOutTime() {
        return afternoonOutTime;
    }

    public void setAfternoonOutTime(String afternoonOutTime) {
        this.afternoonOutTime = afternoonOutTime;
    }

    public String getEveningEnterTime() {
        return eveningEnterTime;
    }

    public void setEveningEnterTime(String eveningEnterTime) {
        this.eveningEnterTime = eveningEnterTime;
    }

    public String getEveningOutTime() {
        return eveningOutTime;
    }

    public void setEveningOutTime(String eveningOutTime) {
        this.eveningOutTime = eveningOutTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
