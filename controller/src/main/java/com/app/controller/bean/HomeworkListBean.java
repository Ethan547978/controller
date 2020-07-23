package com.app.controller.bean;


import java.io.Serializable;
import java.util.List;

public class HomeworkListBean implements Serializable {
    private int current;
    private int size;
    private List<HomeworkBean> records;

    public class HomeworkBean implements Serializable{
        private int id;//作业id
        private int gradeType;//年级类型：1.小学，2.初中，3.高中，4.大学
        private int grade;
        private int classNum;
        private String subject;//科目
        private String content;
        private int weekday;
        private int onlineSubmit;//是否在线提交，1.是，2.否
        private String createTime;//提交时间，yyyy-MM-dd HH:mm
        private int totalStudent;//学生总数
        private int submitStudent;//已交人数
        private String teacherName;
        private int scoreCount;//已批改人数，当用户为老师时有值
        private int isFinish;//当用户为家长时有值：是否完成，0.未完成，1.已完成
        private HomeworkDetailBean detail;
        private boolean isShowTimeLine;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public int getWeekday() {
            return weekday;
        }

        public void setWeekday(int weekday) {
            this.weekday = weekday;
        }

        public int getOnlineSubmit() {
            return onlineSubmit;
        }

        public void setOnlineSubmit(int onlineSubmit) {
            this.onlineSubmit = onlineSubmit;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getTotalStudent() {
            return totalStudent;
        }

        public void setTotalStudent(int totalStudent) {
            this.totalStudent = totalStudent;
        }

        public String getTeacherName() {
            return teacherName;
        }

        public void setTeacherName(String teacherName) {
            this.teacherName = teacherName;
        }

        public int getSubmitStudent() {
            return submitStudent;
        }

        public void setSubmitStudent(int submitStudent) {
            this.submitStudent = submitStudent;
        }

        public int getScoreCount() {
            return scoreCount;
        }

        public void setScoreCount(int scoreCount) {
            this.scoreCount = scoreCount;
        }

        public boolean getIsFinish() {
            return isFinish == 1;
        }

        public void setIsFinish(int isFinish) {
            this.isFinish = isFinish;
        }

        public HomeworkDetailBean getDetail() {
            return detail;
        }

        public void setDetail(HomeworkDetailBean detail) {
            this.detail = detail;
        }

        public boolean isShowTimeLine() {
            return isShowTimeLine;
        }

        public void setShowTimeLine(boolean showTimeLine) {
            isShowTimeLine = showTimeLine;
        }
    }


    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<HomeworkBean> getRecords() {
        return records;
    }

    public void setRecords(List<HomeworkBean> records) {
        this.records = records;
    }
}
