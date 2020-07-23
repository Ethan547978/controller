package com.app.controller.bean;


import java.io.Serializable;
import java.util.ArrayList;

public class HomeworkScoreListBean implements Serializable {

    private int id;//作业id
    private String subject;//科目
    private String content;
    private String createTime;//提交时间，yyyy-MM-dd HH:mm
    private int submitCount;//提交数
    private int unSubmitCount;//未提交数
    private ArrayList<HomeworkDetailBean> submitList;
    private ArrayList<UnSubmitInfo> unSubmitList;

    public class UnSubmitInfo implements Serializable {
        private String name;//学生姓名
        private String logo;//家长用户id
        private int parentId;
        private int parentSex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getParentSex() {
            return parentSex;
        }

        public void setParentSex(int parentSex) {
            this.parentSex = parentSex;
        }
    }

    public ArrayList<HomeworkDetailBean> getSubmitList() {
        return submitList;
    }

    public void setSubmitList(ArrayList<HomeworkDetailBean> submitList) {
        this.submitList = submitList;
    }

    public ArrayList<UnSubmitInfo> getUnSubmitList() {
        return unSubmitList;
    }

    public void setUnSubmitList(ArrayList<UnSubmitInfo> unSubmitList) {
        this.unSubmitList = unSubmitList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getSubmitCount() {
        return submitCount;
    }

    public void setSubmitCount(int submitCount) {
        this.submitCount = submitCount;
    }

    public int getUnSubmitCount() {
        return unSubmitCount;
    }

    public void setUnSubmitCount(int unSubmitCount) {
        this.unSubmitCount = unSubmitCount;
    }

}
