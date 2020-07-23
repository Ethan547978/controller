package com.app.controller.bean;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class TeacherInfo implements Serializable {
    @Expose
    private int userId;
    @Expose
    private int departmentId;//部门Id
    @Expose
    private String departmentName;//部门名称
    @Expose
    private String name;
    @Expose
    private int role;//职工角色：1.校长，2.副校长，3.主任，4.副主任，5.老师，6.门卫 7.安全主任
    @Expose
    private int headTeacher;//是否班主任，0.否，1.是
    @Expose
    private int isLeader;//是否主管，0.否，1.是
    @Expose
    private String mobile;//电话
    @Expose
    private String logo;//头像url
    @Expose
    private int sex;//性别，0.未知，1.男，2.女
    @Expose
    private String title;//职称
    @Expose
    private String job;//职务
    @Expose
    private int age;//年龄
    @Expose
    private String graduate;//最高院校
    @Expose
    private String major;//最高专业
    @Expose
    private String education;//最高学历
    @Expose
    private String hometown;//籍贯
    @Expose
    private String imGroupId;//教职工交流群id

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

    public int getIsLeader() {
        return isLeader;
    }

    public String getImGroupId() {
        return imGroupId;
    }

    public void setGroupId(String imGroupId) {
        this.imGroupId = imGroupId;
    }

    @Override
    public String toString() {
        return "TeacherInfo{" +
                "userId=" + userId +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", headTeacher=" + headTeacher +
                ", isLeader=" + isLeader +
                ", mobile='" + mobile + '\'' +
                ", logo='" + logo + '\'' +
                ", sex=" + sex +
                ", title='" + title + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                ", graduate='" + graduate + '\'' +
                ", major='" + major + '\'' +
                ", education='" + education + '\'' +
                ", hometown='" + hometown + '\'' +
                ", imGroupId='" + imGroupId + '\'' +
                '}';
    }
}
