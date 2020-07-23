package com.app.controller.bean;

import java.io.Serializable;
import java.util.ArrayList;


public class LoginBean  implements Serializable {
    private int type;//用户类型：1.教职工，2.家长，3.学生
    private String token;
    private int userId;
    private String name;
    private String logo;
    private String mobile;
    private String imUsername;
    private String imPassword;
    private SchoolInfo school;
    private TeacherInfo teacher;//教职工，如果type=1，才会有值，字段同教职工脸谱数据
    private ArrayList<ClassInfo> classes;//班主任负责的班级，当用户是教职工并且当headTeacher=1时才有值
    private ArrayList<StudentInfo> students;//家长的多个孩子学生，如果type=2，才会有值，字段同学生脸谱数据

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public ArrayList<StudentInfo> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<StudentInfo> students) {
        this.students = students;
    }

    public SchoolInfo getSchool() {
        return school;
    }

    public void setSchool(SchoolInfo school) {
        this.school = school;
    }

    public TeacherInfo getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherInfo teacher) {
        this.teacher = teacher;
    }

    public ArrayList<ClassInfo> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<ClassInfo> classes) {
        this.classes = classes;
    }

    //    @Override
//    public String toString() {
//        return "LoginBean{" +
//                "accessToken='" + accessToken + '\'' +
//                ", socketToken='" + socketToken + '\'' +
//                ", user=" + user.toString() +
//                '}';
//    }
}
