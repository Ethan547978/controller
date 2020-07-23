package com.app.controller.bean;

import java.io.Serializable;
import java.util.List;

public class ChatTeacherInfo implements Serializable {
    private int userId;
    private int departmentId;//部门Id
    private String departmentName;//部门名称
    private String name;
    private int role;//职工角色：1.校长，2.副校长，3.主任，4.副主任，5.老师，6.门卫
    private int headTeacher;//是否班主任，0.否，1.是
    private int isLeader;//是否主管，0.否，1.是
    private String mobile;//电话
    private String logo;//头像url
    private int sex;//性别，0.未知，1.男，2.女
    private String title;//职称
    private String job;//职务
    private int age;//年龄
    private String graduate;//最高院校
    private String major;//最高专业
    private String education;//最高学历
    private String hometown;//籍贯
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

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean getHeadTeacher() {
        return headTeacher == 1;
    }

    public void setHeadTeacher(int headTeacher) {
        this.headTeacher = headTeacher;
    }

    public boolean isLeader() {
        return isLeader == 1;
    }

    public void setIsLeader(int isLeader) {
        this.isLeader = isLeader;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getSex() {
        return sex;
    }

    public boolean isBoy() {
        return sex == 1;
    }

    public boolean isGirl() {
        return sex == 2;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGraduate() {
        return graduate;
    }

    public void setGraduate(String graduate) {
        this.graduate = graduate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}
