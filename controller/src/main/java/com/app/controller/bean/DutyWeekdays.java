package com.app.controller.bean;

public class DutyWeekdays {
    /**
     * "dutyNum": 6,
     *                     "dutyContent": "擦黑板",
     *                     "userId": 23,
     *                     "name": "C罗",
     *                     "sno": "1232323232323232",
     *                     "weekday": 1
     */
    private int dutyNum;
    private String dutyContent;
    private int userId;
    private String name;
    private String sno;
    private String logo;
    private int dutyweekdayNum;
    private int weekday;
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public int getDutyweekdayNum() {
        return dutyweekdayNum;
    }

    public void setDutyweekdayNum(int dutyweekdayNum) {
        this.dutyweekdayNum = dutyweekdayNum;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }
}
