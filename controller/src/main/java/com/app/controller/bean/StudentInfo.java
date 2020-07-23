package com.app.controller.bean;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class StudentInfo implements Serializable {
    @Expose
    private int userId;
    @Expose
    private String name;
    @Expose
    private String sno;//学号
    @Expose
    private String logo;//头像url
    @Expose
    private String imei;//
    @Expose
    private String mobile;//
    @Expose
    private String schoolName;//学校名称
    @Expose
    private String parentName;//监护人名称
    @Expose
    private String parentMobile;//监护人电话
    @Expose
    private int parentSex;//监护人性别 0.未知，1.男，2.女
    @Expose
    private int gradeType;//年级类型：1.小学，2.初中，3.高中，4.大学
    @Expose
    private int grade;//年级数
    @Expose
    private int classNum;//班数
    @Expose
    private int sex;//性别，0.未知，1.男，2.女
    @Expose
    private String birthday;//生日，yyyy-MM-dd
    @Expose
    private String schoolDate;//入学日期，yyyy-MM-dd
    @Expose
    private String imUsername;//环信用户名
    @Expose
    private String imPassword;//环信密码
    @Expose
    private String imGroupId;//家长群id

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentMobile() {
        return parentMobile;
    }

    public void setParentMobile(String parentMobile) {
        this.parentMobile = parentMobile;
    }

    public int getGradeType() {
        return gradeType;
    }

    public void setGradeType(int gradeType) {
        this.gradeType = gradeType;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public boolean isBoy() {
        return sex == 1;
    }

    public boolean isGirl() {
        return sex == 2;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSchoolDate() {
        return schoolDate;
    }

    public void setSchoolDate(String schoolDate) {
        this.schoolDate = schoolDate;
    }

    public int getParentSex() {
        return parentSex;
    }

    public boolean isParentDad() {
        return parentSex == 1;
    }

    public boolean isParentMom() {
        return parentSex == 2;
    }

    public void setParentSex(int parentSex) {
        this.parentSex = parentSex;
    }

    public String getImUsername() {
        return imUsername;
    }

    public void setImUsername(String imUsername) {
        this.imUsername = imUsername;
    }

    public String getImPassword() {
        return imPassword;
    }

    public void setImPassword(String imPassword) {
        this.imPassword = imPassword;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImGroupId() {
        return imGroupId;
    }

    public void setImGroupId(String imGroupId) {
        this.imGroupId = imGroupId;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", sno='" + sno + '\'' +
                ", logo='" + logo + '\'' +
                ", imei='" + imei + '\'' +
                ", mobile='" + mobile + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", parentName='" + parentName + '\'' +
                ", parentMobile='" + parentMobile + '\'' +
                ", parentSex=" + parentSex +
                ", gradeType=" + gradeType +
                ", grade=" + grade +
                ", classNum=" + classNum +
                ", sex=" + sex +
                ", birthday='" + birthday + '\'' +
                ", schoolDate='" + schoolDate + '\'' +
                ", imUsername='" + imUsername + '\'' +
                ", imPassword='" + imPassword + '\'' +
                ", imPassword='" + imGroupId + '\'' +
                '}';
    }
}
