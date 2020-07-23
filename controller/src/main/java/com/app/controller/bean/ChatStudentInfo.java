package com.app.controller.bean;

import java.io.Serializable;
import java.util.List;

public class ChatStudentInfo implements Serializable {

    private int userId;
    private String name;
    private String sno;//学号
    private String logo;//头像url
    private String schoolName;//学校名称
    private String parentName;//监护人名称
    private String parentMobile;//监护人电话
    private int parentSex;//监护人性别 0.未知，1.男，2.女
    private int gradeType;//年级类型：1.小学，2.初中，3.高中，4.大学
    private int grade;//年级数
    private int classNum;//班数
    private int sex;//性别，0.未知，1.男，2.女
    private String birthday;//生日，yyyy-MM-dd
    private String schoolDate;//入学日期，yyyy-MM-dd
    private List<GroupInfo> groupList;

    public List<GroupInfo> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupInfo> groupList) {
        this.groupList = groupList;
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
}
