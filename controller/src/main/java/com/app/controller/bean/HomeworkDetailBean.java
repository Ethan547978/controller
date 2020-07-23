package com.app.controller.bean;


import java.io.Serializable;

public class HomeworkDetailBean implements Serializable {

    private int id;//作业详情id，可作为修改作业时传入
    private int workId;//老师布置的作业id
    private String studentName;
    private int parentSex;//家长性别，0.未知，1.爸爸，2.妈妈
    private String parentLogo;
    private String content;//家长提交的作业详情内容
    private int status;//状态：0.打回，1.待批改，2.已批改
    private int teacherId;
    private String teacherName;
    private String score;//评分，当status=2时有值
    private String scoreTime;//批改时间，yyyy-MM-dd HH:mm:ss，当status=2时有值
    private String remark;//评语，当status=2时有值
    private int isLike;//是否点赞，1.是，2.否，当status=2时有值
    private int isRecommend;//是否推荐，1.是，2.否，当status=2时有值
    private String studentAttach;//学生作业附件url，多个以英文逗号隔开
    private String teacherAttach;//老师批改作业附件url，多个以英文逗号隔开，当status=2时有值
    private String createTime;//作业提交时间，yyyy-MM-dd HH:mm:ss
    private boolean isShowMore;//本地字段

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getParentLogo() {
        return parentLogo;
    }

    public void setParentLogo(String parentLogo) {
        this.parentLogo = parentLogo;
    }

    public int getParentSex() {
        return parentSex;
    }

    public void setParentSex(int parentSex) {
        this.parentSex = parentSex;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScoreTime() {
        return scoreTime;
    }

    public void setScoreTime(String scoreTime) {
        this.scoreTime = scoreTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean getIsLike() {
        return isLike == 1;
    }

    public void setIsLike(int isLike) {
        this.isLike = isLike;
    }

    public int getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(int isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getStudentAttach() {
        return studentAttach;
    }

    public void setStudentAttach(String studentAttach) {
        this.studentAttach = studentAttach;
    }

    public String getTeacherAttach() {
        return teacherAttach;
    }

    public void setTeacherAttach(String teacherAttach) {
        this.teacherAttach = teacherAttach;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public boolean isShowMore() {
        return isShowMore;
    }

    public void setShowMore(boolean showMore) {
        isShowMore = showMore;
    }
}
