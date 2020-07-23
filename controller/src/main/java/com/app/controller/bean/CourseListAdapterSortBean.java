package com.app.controller.bean;

import java.util.Comparator;
import java.util.List;

public class CourseListAdapterSortBean implements Comparator<CourseListAdapterSortBean> {
    private Integer num;
    private String startTime;
    private String endTime;
    private List<CourseAdapterBean> courseList;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


    public List<CourseAdapterBean> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseAdapterBean> courseList) {
        this.courseList = courseList;
    }

    @Override
    public int compare(CourseListAdapterSortBean o1, CourseListAdapterSortBean o2) {
        return o1.num.compareTo(o2.num);
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
}
