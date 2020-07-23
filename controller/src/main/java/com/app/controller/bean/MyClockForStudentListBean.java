package com.app.controller.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class MyClockForStudentListBean implements Serializable {
    private int current;
    private int size;
    private ArrayList<MyClockForStudentDetailBean> records;


    public static class MyClockForStudentDetailBean implements Serializable {
        private int id;
        private int userId;
        private String userName;
        private String sno;
        private int schoolId;
        private int grade;
        private int gradeType;
        private int classNum;
        private String schoolYear;
        private String logo;
        private String clockTime;
        private int period;
        private int clockType;
        private int status;
        private int lateMinutes;
        private int earlyMinutes;
        private String remark;
        private String createTime;
        private String updateTime;
        private boolean isUnComplete;//本地字段

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getSno() {
            return sno;
        }

        public void setSno(String sno) {
            this.sno = sno;
        }

        public int getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(int schoolId) {
            this.schoolId = schoolId;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public int getGradeType() {
            return gradeType;
        }

        public void setGradeType(int gradeType) {
            this.gradeType = gradeType;
        }

        public int getClassNum() {
            return classNum;
        }

        public void setClassNum(int classNum) {
            this.classNum = classNum;
        }

        public String getSchoolYear() {
            return schoolYear;
        }

        public void setSchoolYear(String schoolYear) {
            this.schoolYear = schoolYear;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getClockTime() {
            return clockTime;
        }

        public void setClockTime(String clockTime) {
            this.clockTime = clockTime;
        }

        public int getPeriod() {
            return period;
        }

        public void setPeriod(int period) {
            this.period = period;
        }

        public int getClockType() {
            return clockType;
        }

        public void setClockType(int clockType) {
            this.clockType = clockType;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getLateMinutes() {
            return lateMinutes;
        }

        public void setLateMinutes(int lateMinutes) {
            this.lateMinutes = lateMinutes;
        }

        public int getEarlyMinutes() {
            return earlyMinutes;
        }

        public void setEarlyMinutes(int earlyMinutes) {
            this.earlyMinutes = earlyMinutes;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
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

        public boolean isUnComplete() {
            return isUnComplete;
        }

        public void setUnComplete(boolean unComplete) {
            isUnComplete = unComplete;
        }
    }

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

    public ArrayList<MyClockForStudentDetailBean> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<MyClockForStudentDetailBean> details) {
        this.records = details;
    }
}