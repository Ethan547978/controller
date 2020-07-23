package com.app.controller.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class StatTeacherSummaryBean implements Serializable {
    private int userId;
    private String userName;
    private int userRole;
    private int schoolId;
    private String schoolName;
    private String logo;
    private int attendDays;
    private int unClockedDays;
    private int restDays;
    private int leaveDays;
    private int leaveMinutes;
    private int tranferLeaveDays;
    private int tranferLeaveMinutes;
    private int normalLeaveDays;
    private int normalLeaveMinutes;
    private int bizTripDays;
    private int bizTripMinutes;
    private int lateTimes;
    private int lateMinutes;
    private int earlyTimes;
    private int earlyMinutes;
    private int overtimeDays;
    private int overtimeMinutes;
    private int absenceDays;
    private int absenceMinutes;
    private ArrayList<StatTeacherSummaryDetailBean> details;


    public class StatTeacherSummaryDetailBean implements Serializable {
        private int id;
        private int userId;
        private String userName;
        private int schoolId;
        private String schoolName;
        private String logo;
        private int status;
        private int hasAttended;
        private int unClocked;
        private int isHoliday;
        private int tranferLeaveMinutes;
        private int normalLeaveMinutes;
        private int bizTripMinutes;
        private int lateTimes;
        private int lateMinutes;
        private int earlyTimes;
        private int earlyMinutes;
        private int overtimeMinutes;
        private int absenceMinutes;
        private String attendanceDate;
        private String createTime;
        private String updateTime;

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

        public int getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(int schoolId) {
            this.schoolId = schoolId;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setHasAttended(int hasAttended) {
            this.hasAttended = hasAttended;
        }

        public int getUnClocked() {
            return unClocked;
        }

        public void setUnClocked(int unClocked) {
            this.unClocked = unClocked;
        }

        public int getIsHoliday() {
            return isHoliday;
        }

        public void setIsHoliday(int isHoliday) {
            this.isHoliday = isHoliday;
        }

        public int getTranferLeaveMinutes() {
            return tranferLeaveMinutes;
        }

        public void setTranferLeaveMinutes(int tranferLeaveMinutes) {
            this.tranferLeaveMinutes = tranferLeaveMinutes;
        }

        public int getNormalLeaveMinutes() {
            return normalLeaveMinutes;
        }

        public void setNormalLeaveMinutes(int normalLeaveMinutes) {
            this.normalLeaveMinutes = normalLeaveMinutes;
        }

        public int getBizTripMinutes() {
            return bizTripMinutes;
        }

        public void setBizTripMinutes(int bizTripMinutes) {
            this.bizTripMinutes = bizTripMinutes;
        }

        public int getLateTimes() {
            return lateTimes;
        }

        public void setLateTimes(int lateTimes) {
            this.lateTimes = lateTimes;
        }

        public int getLateMinutes() {
            return lateMinutes;
        }

        public void setLateMinutes(int lateMinutes) {
            this.lateMinutes = lateMinutes;
        }

        public int getEarlyTimes() {
            return earlyTimes;
        }

        public void setEarlyTimes(int earlyTimes) {
            this.earlyTimes = earlyTimes;
        }

        public int getEarlyMinutes() {
            return earlyMinutes;
        }

        public void setEarlyMinutes(int earlyMinutes) {
            this.earlyMinutes = earlyMinutes;
        }

        public int getOvertimeMinutes() {
            return overtimeMinutes;
        }

        public void setOvertimeMinutes(int overtimeMinutes) {
            this.overtimeMinutes = overtimeMinutes;
        }

        public int getAbsenceMinutes() {
            return absenceMinutes;
        }

        public void setAbsenceMinutes(int absenceMinutes) {
            this.absenceMinutes = absenceMinutes;
        }

        public String getAttendanceDate() {
            return attendanceDate;
        }

        public void setAttendanceDate(String attendanceDate) {
            this.attendanceDate = attendanceDate;
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

        public boolean isNormalStatus() {
            return status == 1;
        }

        public boolean isHasAttended() {
            return hasAttended == 1;
        }

        public boolean isLate() {
            return lateTimes > 0;
        }

        public boolean isLeave() {
            return normalLeaveMinutes > 0;
        }

        public boolean isUnClocked() {
            return unClocked == 1;
        }

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

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getAttendDays() {
        return attendDays;
    }

    public void setAttendDays(int attendDays) {
        this.attendDays = attendDays;
    }

    public int getUnClockedDays() {
        return unClockedDays;
    }

    public void setUnClockedDays(int unClockedDays) {
        this.unClockedDays = unClockedDays;
    }

    public int getRestDays() {
        return restDays;
    }

    public void setRestDays(int restDays) {
        this.restDays = restDays;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public int getLeaveMinutes() {
        return leaveMinutes;
    }

    public void setLeaveMinutes(int leaveMinutes) {
        this.leaveMinutes = leaveMinutes;
    }

    public int getTranferLeaveDays() {
        return tranferLeaveDays;
    }

    public void setTranferLeaveDays(int tranferLeaveDays) {
        this.tranferLeaveDays = tranferLeaveDays;
    }

    public int getTranferLeaveMinutes() {
        return tranferLeaveMinutes;
    }

    public void setTranferLeaveMinutes(int tranferLeaveMinutes) {
        this.tranferLeaveMinutes = tranferLeaveMinutes;
    }

    public int getNormalLeaveDays() {
        return normalLeaveDays;
    }

    public void setNormalLeaveDays(int normalLeaveDays) {
        this.normalLeaveDays = normalLeaveDays;
    }

    public int getNormalLeaveMinutes() {
        return normalLeaveMinutes;
    }

    public void setNormalLeaveMinutes(int normalLeaveMinutes) {
        this.normalLeaveMinutes = normalLeaveMinutes;
    }

    public int getBizTripDays() {
        return bizTripDays;
    }

    public void setBizTripDays(int bizTripDays) {
        this.bizTripDays = bizTripDays;
    }

    public int getBizTripMinutes() {
        return bizTripMinutes;
    }

    public void setBizTripMinutes(int bizTripMinutes) {
        this.bizTripMinutes = bizTripMinutes;
    }

    public int getLateTimes() {
        return lateTimes;
    }

    public void setLateTimes(int lateTimes) {
        this.lateTimes = lateTimes;
    }


    public int getLateMinutes() {
        return lateMinutes;
    }

    public void setLateMinutes(int lateMinutes) {
        this.lateMinutes = lateMinutes;
    }

    public int getEarlyTimes() {
        return earlyTimes;
    }

    public void setEarlyTimes(int earlyTimes) {
        this.earlyTimes = earlyTimes;
    }

    public int getEarlyMinutes() {
        return earlyMinutes;
    }

    public void setEarlyMinutes(int earlyMinutes) {
        this.earlyMinutes = earlyMinutes;
    }

    public int getOvertimeDays() {
        return overtimeDays;
    }

    public void setOvertimeDays(int overtimeDays) {
        this.overtimeDays = overtimeDays;
    }

    public int getOvertimeMinutes() {
        return overtimeMinutes;
    }

    public void setOvertimeMinutes(int overtimeMinutes) {
        this.overtimeMinutes = overtimeMinutes;
    }

    public int getAbsenceDays() {
        return absenceDays;
    }

    public void setAbsenceDays(int absenceDays) {
        this.absenceDays = absenceDays;
    }

    public int getAbsenceMinutes() {
        return absenceMinutes;
    }

    public void setAbsenceMinutes(int absenceMinutes) {
        this.absenceMinutes = absenceMinutes;
    }

    public ArrayList<StatTeacherSummaryDetailBean> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<StatTeacherSummaryDetailBean> details) {
        this.details = details;
    }
}