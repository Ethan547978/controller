package com.app.controller.bean

data class MyCourseListBean(
        val type:Int,
        val grade:Int,
        val classNum:Int,
        val weekday:Int,
        val num:Int,
        val startTime:String,
        val endTime:String,
        val courseName:String,
        val address:String
)

data class TeacherCourse(
     val num:Int,
     val courseList:List<MyCourseListBean>?
    )