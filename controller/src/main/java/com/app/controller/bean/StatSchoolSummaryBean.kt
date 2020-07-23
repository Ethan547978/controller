package com.app.controller.bean

data class StatSchoolSummaryBean(
        val schoolId:Int,
        val schoolName:String,
        val attendCount:Int,
        val leaveCount:Int,
        val totalCount:Int,
        val leaveStudents:List<StatSchoolSummaryLeaveStudentBean>
)

data class StatSchoolTeacherSummaryBean(
        val schoolId:Int,
        val schoolName:String,
        val attendCount:Int,
        val leaveCount:Int,
        val totalCount:Int,
        val leaveTeachers:List<StatSchoolSummaryLeaveStudentBean>
)

data class StatSchoolSummaryLeaveStudentBean(
        val id:Int,
        val userId:Int,
        val userName:String,
        val schoolName:String,
        val sno:String,
        val schoolYear:String,
        val logo:String,
        val attendanceDate:String,
        val createTime:String,
        val updateTime:String,
        val schoolId:Int,
        val grade:Int,
        val gradeType:Int,
        val classNum:Int,
        val status:Int,
        val hasAttended:Int,
        val unClocked:Int,
        val isHoliday:Int,
        val tranferLeaveMinutes:Int,
        val normalLeaveMinutes:Int,
        val bizTripMinutes:Int,
        val lateTimes:Int,
        val lateMinutes:Int,
        val earlyTimes:Int,
        val earlyMinutes:Int,
        val overtimeMinutes:Int,
        val absenceMinutes:Int
        )