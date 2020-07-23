package com.app.controller.bean

data class AuditConfigBean(
        val id :Int,
        val schoolId :Int,
        val firstAuditorRole :Int,
        val firstMinDays :Int,
        val firstMaxDays :Int,
        val secondAuditorRole :Int,
        val secondMinDays :Int,
        val secondMaxDays :Int,
        val thirdAuditorRole :Int,
        val thirdMinDays :Int,
        val schoolName :String,
        val createTime :String,
        val updateTime :String
)