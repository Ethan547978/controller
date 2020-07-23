package com.app.controller.store.remote.store;

import com.app.controller.bean.AttendanceConfigBean;
import com.app.controller.bean.AuditConfigBean;
import com.app.controller.bean.BaseBean;
import com.app.controller.bean.CourseAttendBean;
import com.app.controller.bean.LeaseListBean;
import com.app.controller.bean.LeaveStudentBean;
import com.app.controller.bean.LeaveTeacherBean;
import com.app.controller.bean.MyClockForStudentListBean;
import com.app.controller.bean.MyClockForTeacherListBean;
import com.app.controller.bean.StatClassSummary;
import com.app.controller.bean.StatClassSummaryDetail;
import com.app.controller.bean.StatSchoolSummaryBean;
import com.app.controller.bean.StatSchoolTeacherSummaryBean;
import com.app.controller.bean.StatSchoolUserSummaryBean;
import com.app.controller.bean.StatTeacherSummaryBean;
import com.app.controller.bean.StatUserSummaryBean;
import com.app.controller.exception.ClientException;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface HttpAttendanceStore {
    String BASE_URL = "http://47.115.140.192:8763";

    //老师申请请假
    @POST("/api/campus/leave/teacher/v2.0/apply")
    Call<BaseBean<Object>> applyLeave(@Header("token") String token, @Body RequestBody body) throws ClientException;

    //学生申请请假
    @POST("/api/campus/leave/student/v2.0/apply")
    Call<BaseBean<Object>> applyStudentLeave(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/leave/teacher/v2.0/listPersonal")
    Call<BaseBean<LeaseListBean>> listPersonal(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/leave/student/v2.0/listPersonal")
    Call<BaseBean<LeaseListBean>> listStudentPersonal(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/leave/teacher/v2.0/findAudits")
    Call<BaseBean<LeaseListBean>> findAudits(@Header("token") String token, @Body RequestBody body) throws ClientException;

    //老师请假详情
    @POST("/api/campus/leave/teacher/v2.0/get")
    Call<BaseBean<LeaveTeacherBean>> getTeacherLeave(@Header("token") String token, @Body RequestBody body) throws ClientException;
    //学生请假详情
    @POST("/api/campus/leave/student/v2.0/get")
    Call<BaseBean<LeaveStudentBean>> getStudentLeave(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/leave/teacher/v2.0/cancel")
    Call<BaseBean<Integer>> cancelTeacherLeave(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/leave/teacher/v2.0/approve")
    Call<BaseBean<Integer>> approveLeave(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/leave/teacher/v2.0/reject")
    Call<BaseBean<Integer>> rejectLeave(@Header("token") String token, @Body RequestBody body) throws ClientException;
    //新增/修改审批权限配置
    @POST("api/campus/auditConfig/v2.0/save")
    Call<BaseBean<Integer>> saveAuditConfig(@Header("token") String token, @Body RequestBody body) throws ClientException;
    //查询审批权限配置
    @POST("api/campus/auditConfig/v2.0/get")
    Call<BaseBean<AuditConfigBean>> getAuditConfig(@Header("token") String token, @Body RequestBody body) throws ClientException;

    //考勤配置
    @POST("api/campus/attendanceConfig/v2.0/save")
    Call<BaseBean<Integer>> saveAttendanceConfig(@Header("token") String token, @Body RequestBody body) throws ClientException;

    //(老师)考勤汇总
    @POST("api/campus/attendance/teacher/v2.0/statSchoolUserSummary")
    Call<BaseBean<StatSchoolUserSummaryBean>> statSchoolTeacherSummary(@Header("token") String token, @Body RequestBody body) throws ClientException;
    //(老师)学校今日考勤汇总
    @POST("api/campus/attendance/teacher/v2.0/statSchoolSummary")
    Call<BaseBean<StatSchoolTeacherSummaryBean>> statSchoolTeacherTodaySummary(@Header("token") String token, @Body RequestBody body) throws ClientException;
    //(老师)个人考勤汇总
    @POST("api/campus/attendance/teacher/v2.0/statUserSummary")
    Call<BaseBean<StatUserSummaryBean>> statUserTeacherSummary(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("api/campus/attendanceConfig/v2.0/find")
    Call<BaseBean<AttendanceConfigBean>> findAttendanceConfig(@Header("token") String token, @Body RequestBody body) throws ClientException;
    //(学生)考勤汇总
    @POST("api/campus/attendance/student/v2.0/statSchoolUserSummary")
    Call<BaseBean<StatSchoolUserSummaryBean>> statSchoolUserSummary(@Header("token") String token, @Body RequestBody body) throws ClientException;
    //(学生)个人考勤统计
    @POST("api/campus/attendance/student/v2.0/statUserSummary")
    Call<BaseBean<StatUserSummaryBean>> statUserSummary(@Header("token") String token, @Body RequestBody body) throws ClientException;
    //(学生)学校今日考勤汇总
    @POST("api/campus/attendance/student/v2.0/statSchoolSummary")
    Call<BaseBean<StatSchoolSummaryBean>> statSchoolSummary(@Header("token") String token, @Body RequestBody body) throws ClientException;

    //(教职工)个人考勤统计
    @POST("/api/campus/attendance/teacher/v2.0/statUserSummary")
    Call<BaseBean<StatTeacherSummaryBean>> statTeacherSummary(@Header("token") String token, @Body RequestBody body) throws ClientException;

    //(教职工)我的刷卡列表
    @POST("/api/campus/attendance/teacher/v2.0/myClockList")
    Call<BaseBean<MyClockForTeacherListBean>> myClockListForTeacher(@Header("token") String token, @Body RequestBody body) throws ClientException;

    //((学生)我的刷卡列表
    @POST("/api/campus/attendance/student/v2.0/myClockList")
    Call<BaseBean<MyClockForStudentListBean>> myClockListForStudent(@Header("token") String token, @Body RequestBody body) throws ClientException;

    //((学生)班级考勤-当日详情
    @POST("/api/campus/attendance/student/v2.0/statClassSummaryDetail")
    Call<BaseBean<StatClassSummaryDetail>> statClassSummaryDetail(@Header("token") String token, @Body RequestBody body) throws ClientException;

    //((学生)班级考勤-历史考勤
    @POST("/api/campus/attendance/student/v2.0/statClassSummary")
    Call<BaseBean<StatClassSummary>> statClassSummary(@Header("token") String token, @Body RequestBody body) throws ClientException;

    //(学生)课程考勤
    @POST("/api/campus/courseAttend/v2.0/find")
    Call<BaseBean<CourseAttendBean>> findCourseAttend(@Header("token") String token, @Body RequestBody body) throws ClientException;

    //(学生)课程考勤 签到
    @POST("/api/campus/courseAttend/v2.0/attend")
    Call<BaseBean<Integer>> courseAttend(@Header("token") String token, @Body RequestBody body) throws ClientException;

    //(学生)课程考勤 取消
    @POST("/api/campus/courseAttend/v2.0/cancelAttend")
    Call<BaseBean<Integer>> cancelAttend(@Header("token") String token, @Body RequestBody body) throws ClientException;

    //(学生)课程考勤 一键签到
    @POST("/api/campus/courseAttend/v2.0/allAttend")
    Call<BaseBean<Integer>> allAttend(@Header("token") String token, @Body RequestBody body) throws ClientException;


}
