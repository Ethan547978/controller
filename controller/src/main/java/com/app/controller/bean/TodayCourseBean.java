package com.app.controller.bean;


import android.content.Context;

import com.app.library.utils.TimeUtil;

import java.io.Serializable;
import java.util.Calendar;

public class TodayCourseBean implements Serializable {

    private int type;//年级类型：1.小学，2.初中，3.高中，4.大学
    private int grade;//年级数
    private int classNum;//班数
    private int weekday;
    private int num;//第几节
    private int courseId;//课程Id
    private String startTime;
    private String endTime;
    private String courseName;//课名
    private String address;//授课地点

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTeachStatus(Context context){//1-备课中 2-授课中 3-结束
         String finalStartTimeStr = TimeUtil.format14(context, System.currentTimeMillis()) + " " + getStartTime() + ":00";
        long startTime = TimeUtil.convertTimeString2Long(finalStartTimeStr, Calendar.SECOND);
        String finalEndTimeStr = TimeUtil.format14(context, System.currentTimeMillis()) + " " + getEndTime() + ":00";
        long endTime = TimeUtil.convertTimeString2Long(finalEndTimeStr, Calendar.SECOND);
        if (startTime > System.currentTimeMillis()) {
            return 1;
        }   else if (endTime < System.currentTimeMillis()) {
            return 3;
        }else{
            return 2;
        }
    }
}
