package com.app.controller.store.remote.store;

import com.app.controller.bean.BaseBean;
import com.app.controller.bean.ClassInfo;
import com.app.controller.bean.DutyBean;
import com.app.controller.bean.DutyWeekdays;
import com.app.controller.bean.GradeInfoBean;
import com.app.controller.bean.JobBean;
import com.app.controller.bean.StudentInfo;
import com.app.controller.exception.ClientException;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface HttpClassStore {

    String BASE_URL = "http://47.115.140.192:8763";
    /**
     * 班级学生列表
     * @throws ClientException
     */
    @POST("/api/campus/school/v2.0/class/student/list")
    Call<BaseBean<List<StudentInfo>>> getStudentList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    /**
     * 班级学生职务列表
     * @throws ClientException
     */
    @POST("/api/campus/school/v2.0/class/student/job/list")
    Call<BaseBean<List<JobBean>>> getStudentJobList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    /**
     * 全部值日列表
     * @throws ClientException
     */
    @POST("/api/campus/school/v2.0/class/student/duty/list")
    Call<BaseBean<List<DutyBean>>> getStudentDutyList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    /**
     * @throws ClientException
     */
    @POST("/api/campus/school/v2.0/class/student/duty/today")
    Call<BaseBean<List<DutyWeekdays>>> getStudentDutyToday(@Header("token") String token, @Body RequestBody body) throws ClientException;
    /**
     * 增加值日
     */
    @POST("/api/campus/school/v2.0/class/student/duty/save")
    Call<BaseBean<Integer>> saveStudentDuty(@Header("token") String token, @Body RequestBody body) throws ClientException;
    /**
     * 删除值日
     */
    @POST("/api/campus/school/v2.0/class/student/duty/delete")
    Call<BaseBean<Integer>> deleteStudentDuty(@Header("token") String token, @Body RequestBody body) throws ClientException;
    /**
     * 值日详情
     */
    @POST("/api/campus/school/v2.0/class/student/duty/detail")
    Call<BaseBean<DutyBean>> getStudentDutyDetail(@Header("token") String token, @Body RequestBody body) throws ClientException;

    /**
     * @throws ClientException
     */
    @POST("/api/campus/school/v2.0/class/student/job/list")
    Call<BaseBean<List<JobBean>>> getStudentJob(@Header("token") String token, @Body RequestBody body) throws ClientException;

    /**
     * @throws ClientException
     */
    @POST("/api/campus/school/v2.0/class/student/job/save")
    Call<BaseBean<Integer>> saveStudentJob(@Header("token") String token, @Body RequestBody body) throws ClientException;

    /**
     * @throws ClientException
     */
    @POST("/api/campus/school/v2.0/class/student/job/save")
    Call<BaseBean<Integer>> getClassNotice(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/school/v2.0/class/list")
    Call<BaseBean<List<ClassInfo>>> getClassList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/school/v2.0/grade/list")
    Call<BaseBean<List<GradeInfoBean>>> getGradeList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/school/v2.0/grade/save")
    Call<BaseBean<Integer>> saveGrade(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/school/v2.0/grade/delete")
    Call<BaseBean<Integer>> deleteGrade(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/school/v2.0/class/save")
    Call<BaseBean<Integer>> saveClass(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/school/v2.0/class/delete")
    Call<BaseBean<Integer>> deleteClass(@Header("token") String token, @Body RequestBody body) throws ClientException;


}
