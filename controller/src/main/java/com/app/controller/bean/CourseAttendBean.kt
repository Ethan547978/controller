package com.app.controller.bean

data class CourseAttendBean(
        val normalCount:Int,
        val absenceCount:Int,
        val course:CourseAttendCourseBean,
        val attends:List<CourseAttendsListBean>
)

data class CourseAttendCourseBean(
        val startTime:String,
        val courseName:String,
        val endTime:String,
        val gradeType:Int,
        val grade:Int,
        val classNum:Int
)

data class CourseAttendsListBean(
        val courseDate:String,
        val studentName:String,
        val createTime:String,
        val updateTime:String,
        val id:Int,
        val courseId:Int,
        val studentId:Int,
        val sno:Int,
        val status:Int
)
