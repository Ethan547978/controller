package com.app.controller.bean

data class LeaveTeacherBean(
        val id: Int,
        val userId: Int,
        val userName: String,
        val userRole: Int,
        val schoolId: Int,
        val schoolName: String,
        val logo: String,
        val leaveType: Int,
        val grade: Int,
        val gradeType: Int,
        val classNum: Int,
        val schoolYear: String,
        val startTime: String,
        val endTime: String,
        val minutes: Int,
        val reason: String,
        val images: String?,
        val auditStatus: Int,
        val createTime: String,
        val updateTime: String,
        val processes:List<LeaveProcessBean>
)
data class LeaveStudentBean(
        val id: Int,
        val userId: Int,
        val userName: String,
        val userRole: Int,
        val schoolId: Int,
        val schoolName: String,
        val parentId: Int,
        val parentMobile: String,
        val parentName: String,
        val logo: String,
        val leaveType: Int,
        val grade: Int,
        val gradeType: Int,
        val classNum: Int,
        val schoolYear: String,
        val startTime: String,
        val endTime: String,
        val minutes: Int,
        val reason: String,
        val images: String?,
        val auditStatus: Int,
        val createTime: String,
        val updateTime: String,
        val processes:List<LeaveProcessBean>
)
data class LeaveProcessBean(
        val id:String,
        val auditorId:String,
        val auditor:String,
        val auditorRole:String,
        val auditorLogo:String,
        val auditType:String,
        val auditStatus:String,
        val auditContent:String,
        val auditTime:String
)
data class LeaveApproveProcessBean(
        val id:String,
        val auditorId:String,
        val auditor:String,
        val auditorRole:Int,
        val auditorLogo:String,
        val auditType:String,
        val auditStatus:String,
        val auditContent:String,
        val auditTime:String
)