package com.app.controller.bean

data class GoodListBean(
        val current:Int,
        val size :Int,
        var records: MutableList<GoodListInfoBean>
)

data class GoodListInfoBean(
        val id:Int,
        val workId :Int,
        val parentSex :Int,
        val studentId :Int,
        val studentName :String,
        val content :String,
        val teacherName :String,
        val scoreTime :String,
        val score :String,
        val remark :String,
        val status :Int,
        val teacherId :Int,
        val isLike :Int,
        val isRecommend :Int,
        val studentAttach :String,
        val teacherAttach:String,
        val createTime:String
)
/**
 *
 *  "id": 24,
"workId": 10,
"studentId": 3,
"studentName": "学生1",
"parentSex": 0,
"content": "848118",
"status": 2,
"teacherId": 2,
"teacherName": "家长1",
"scoreTime": "2020-05-26 19:55:50",
"score": "A+",
"remark": "阿拉辣条",
"isLike": 2,
"isRecommend": 1,
"studentAttach": "https://hsm-bucket.oss-cn-shenzhen.aliyuncs.com/campus/parents/android/1589977930450.jpg,https://hsm-bucket.oss-cn-shenzhen.aliyuncs.com/campus/parents/android/1589977931140.jpg,https://hsm-bucket.oss-cn-shenzhen.aliyuncs.com/campus/parents/android/1589977931579.mp4",
"teacherAttach": "https://hsm-bucket.oss-cn-shenzhen.aliyuncs.com/campus/parents/android/1590494148512.jpg",
"createTime": "2020-05-20 20:32:26"

        **/