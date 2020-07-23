package com.app.controller.bean;

import java.io.Serializable;

public class VisitorInfo implements Serializable {
    private int id;
    private String name;
    private String idNo;//身份证号码
    private String picture;//头像url
    private String mobile;//
    private String visitDate;//
    private String visitTimeStart;//
    private String visitTimeEnd;//
    private int visitReason;//
    private int visitUserId;//
    private String visitMobile;//
    private String visitName;//
    private String remark;//
    private String together;//
    private String arriveTime;//
    private String arrivePicture;//
    private int status;//状态，1.待审核，2.待访问，3.已完成，4.已失效
    private String createTime;//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitTimeStart() {
        return visitTimeStart;
    }

    public void setVisitTimeStart(String visitTimeStart) {
        this.visitTimeStart = visitTimeStart;
    }

    public String getVisitTimeEnd() {
        return visitTimeEnd;
    }

    public void setVisitTimeEnd(String visitTimeEnd) {
        this.visitTimeEnd = visitTimeEnd;
    }

    public int getVisitReason() {
        return visitReason;
    }

    public void setVisitReason(int visitReason) {
        this.visitReason = visitReason;
    }

    public int getVisitUserId() {
        return visitUserId;
    }

    public void setVisitUserId(int visitUserId) {
        this.visitUserId = visitUserId;
    }

    public String getVisitMobile() {
        return visitMobile;
    }

    public void setVisitMobile(String visitMobile) {
        this.visitMobile = visitMobile;
    }

    public String getVisitName() {
        return visitName;
    }

    public void setVisitName(String visitName) {
        this.visitName = visitName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTogether() {
        return together;
    }

    public void setTogether(String together) {
        this.together = together;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getArrivePicture() {
        return arrivePicture;
    }

    public void setArrivePicture(String arrivePicture) {
        this.arrivePicture = arrivePicture;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
