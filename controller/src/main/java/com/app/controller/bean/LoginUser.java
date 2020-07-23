package com.app.controller.bean;

/**
 * Created by Jackie on 05,九月,2017
 */

public class LoginUser {
    
    private Long id;
    private String phone;
    private String openId;
    private String passwd;
    private String source;
    private String nick;
    private String photo;
    private String sign;
    private String forbiddenReason;
    private String ctime;
    private String utime;
    private int sex;
    private int identity;
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getForbiddenReason() {
        return forbiddenReason;
    }

    public void setForbiddenReason(String forbiddenReason) {
        this.forbiddenReason = forbiddenReason;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", openId='" + openId + '\'' +
                ", passwd='" + passwd + '\'' +
                ", source='" + source + '\'' +
                ", nick='" + nick + '\'' +
                ", photo='" + photo + '\'' +
                ", sign='" + sign + '\'' +
                ", forbiddenReason='" + forbiddenReason + '\'' +
                ", ctime='" + ctime + '\'' +
                ", utime='" + utime + '\'' +
                ", sex=" + sex +
                ", identity=" + identity +
                ", status=" + status +
                '}';
    }
}
