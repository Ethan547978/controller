package com.app.controller.bean

data class StatClassSummaryDetail(
        val earlyStudents:List<StatAttendanceStudent>,
        val leaveStudents:List<StatSchoolSummaryLeaveStudentBean>,
        val lateStudents:List<StatAttendanceStudent>,
        val periodAttendances:List<PeriodAttendances>
)

data class StatAttendanceStudent(
        val userId:Int,
        val userName:String,
        val sno:String,
        val clockTime:String
)
data class PeriodAttendances(
        val period:Int,
        val schoolId:Int,
        val grade:Int,
        val gradeType:Int,
        val classNum:Int,
        val attendCount:Int,
        val totalCount:Int,
        val leaveCount:Int,
        val lateCount:Int,
        val earlyCount:Int,
        val attendanceDate:String
)