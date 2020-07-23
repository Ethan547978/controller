package com.app.controller.bean;

/**
 * Created by hp on 2017/9/29.
 */

public class PersonalInfo {
    private int uid;
    private String phone;
    private String openId;
    private String source;
    private String nick;
    private int sex;
    private String sign;
    private String photo;
    private int identity;
    private int toFollowCount;
    private int fromFollowCount;
    private int consumeLevel;
    private int anchorLevel;
    private int goldBalance;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public int getToFollowCount() {
        return toFollowCount;
    }

    public void setToFollowCount(int toFollowCount) {
        this.toFollowCount = toFollowCount;
    }

    public int getFromFollowCount() {
        return fromFollowCount;
    }

    public void setFromFollowCount(int fromFollowCount) {
        this.fromFollowCount = fromFollowCount;
    }

    public int getConsumeLevel() {
        return consumeLevel;
    }

    public void setConsumeLevel(int consumeLevel) {
        this.consumeLevel = consumeLevel;
    }

    public int getAnchorLevel() {
        return anchorLevel;
    }

    public void setAnchorLevel(int anchorLevel) {
        this.anchorLevel = anchorLevel;
    }

    public int getGoldBalance() {
        return goldBalance;
    }

    public void setGoldBalance(int goldBalance) {
        this.goldBalance = goldBalance;
    }

    @Override
    public String toString() {
        return "PersonalInfo{" +
                "uid=" + uid +
                ", phone='" + phone + '\'' +
                ", openId='" + openId + '\'' +
                ", source='" + source + '\'' +
                ", nick='" + nick + '\'' +
                ", sex=" + sex +
                ", sign='" + sign + '\'' +
                ", photo='" + photo + '\'' +
                ", identity=" + identity +
                ", toFollowCount=" + toFollowCount +
                ", fromFollowCount=" + fromFollowCount +
                ", consumeLevel=" + consumeLevel +
                ", anchorLevel=" + anchorLevel +
                ", goldBalance=" + goldBalance +
                '}';
    }
}
