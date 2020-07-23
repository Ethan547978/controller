package com.app.controller.bean

data class RecommendListBean(
        val current:Int,
        val size :Int,
        var records: MutableList<RecommendListRecordsBean>
)

data class RecommendListRecordsBean(
        val id: Int,
        val workId: Int,
        val studentId: Int,
        val parentSex: Int,
        val status: Int,
        val teacherId: Int,
        val isLike: Int,
        val isRecommend: Int,
        val gradeType: Int,
        val grade: Int,
        val classNum: Int,
        val studentName: String,
        val content: String,
        val teacherName: String,
        val scoreTime: String,
        val score: String,
        val remark: String,
        val studentAttach: String,
        val teacherAttach: String,
        val createTime: String,
        val subject: String
)
/**
"id": 20,
"workId": 10,
"studentId": 3,
"studentName": "学生1",
"parentSex": 0,
"content": "孤零零",
"status": 2,
"teacherId": 4,
"teacherName": "老师1",
"scoreTime": "2020-05-26 16:34:30",
"score": "A+",
"remark": "88888888",
"isLike": 1,
"isRecommend": 2,
"studentAttach": "https://hsm-bucket.oss-cn-shenzhen.aliyuncs.com/campus/parents/android/1589976883199.jpg,https://hsm-bucket.oss-cn-shenzhen.aliyuncs.com/campus/parents/android/1589976883979.jpg,https://hsm-bucket.oss-cn-shenzhen.aliyuncs.com/campus/parents/android/1589976884420.jpg,https://hsm-bucket.oss-cn-shenzhen.aliyuncs.com/campus/parents/android/1589976884593.mp4",
"teacherAttach": "https://hsm-bucket.oss-cn-shenzhen.aliyuncs.com/campus/teacher/ios/20200526163042.png,https://hsm-bucket.oss-cn-shenzhen.aliyuncs.com/campus/teacher/ios/20200526163046.png,https://hsm-bucket.oss-cn-shenzhen.aliyuncs.com/campus/teacher/ios/20200526163323.png,https://hsm-bucket.oss-cn-shenzhen.aliyuncs.com/campus/teacher/ios/20200526163323.png",
"createTime": "2020-05-20 20:14:59",
"gradeType": 1,
"grade": 1,
"classNum": 1,
"subject": "语文"
        */