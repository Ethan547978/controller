package com.app.controller.bean

data class StatClassSummary(
        val current:Int,
        val size :Int,
        val records:List<StatClassSummaryList>
)
data class StatClassSummaryList(
        val attendanceDate:String,
        val schoolId:Int,
        val grade :Int,
        val gradeType :Int,
        val classNum :Int,
        val attendCount :Int,
        val totalCount :Int,
        val leaveCount :Int,
        val lateCount :Int,
        val earlyCount :Int
)