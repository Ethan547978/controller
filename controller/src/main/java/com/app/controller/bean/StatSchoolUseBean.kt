package com.app.controller.bean

data class StatSchoolUserSummaryBean( val current:Int,
                              val size :Int,
                              var records: MutableList<StatSchoolUserSummaryRecordsBean>)

data class StatSchoolUserSummaryRecordsBean(
        val userId:Int,
        val userName :String,
        val sno :String,
        val schoolId :Int,
        val schoolName :String,
        val grade :Int,
        val gradeType :Int,
        val classNum :Int,
        val schoolYear :String,
        val logo :String,
        val attendDays :Int,
        val unClockDays :Int,
        val restDays :Int,
        val tranferLeaveMinutes :Int,
        val normalLeaveMinutes :Int,
        val bizTripMinutes :Int,
        val lateTimes :Int,
        val lateMinutes :Int,
        val earlyTimes :Int,
        val earlyMinutes :Int,
        val overtimeMinutes :Int,
        val absenceMinutes :Int
)
