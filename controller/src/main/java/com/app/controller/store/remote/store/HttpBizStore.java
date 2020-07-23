package com.app.controller.store.remote.store;

import com.app.controller.bean.BaseBean;
import com.app.controller.bean.DepartmentBean;
import com.app.controller.bean.GenCredentialBean;
import com.app.controller.bean.GetStudentListBean;
import com.app.controller.bean.GetTeacherListBean;
import com.app.controller.bean.HomeworkDetailBean;
import com.app.controller.bean.HomeworkListBean;
import com.app.controller.bean.HomeworkScoreListBean;
import com.app.controller.bean.MyGradeClassBean;
import com.app.controller.bean.StudentInfo;
import com.app.controller.bean.TeacherInfo;
import com.app.controller.bean.TodayCourseBean;
import com.app.controller.bean.XuedouDetailBean;
import com.app.controller.exception.ClientException;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Description : 普通业务接口类
 */
public interface HttpBizStore {

    String BASE_URL = "http://47.115.140.192:8763";

    @POST("/api/campus/user/v2.0/teacher/list")
    Call<BaseBean<GetTeacherListBean>> getTeacherList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/teacher/detail")
    Call<BaseBean<TeacherInfo>> getTeacherInfo(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/teacher/save")
    Call<BaseBean<Boolean>> saveTeacherInfo(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/teacher/delete")
    Call<BaseBean<Boolean>> deleteTeacher(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/student/list")
    Call<BaseBean<GetStudentListBean>> getStudentList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/student/detail")
    Call<BaseBean<StudentInfo>> getStudentInfo(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/student/save")
    Call<BaseBean<Boolean>> saveStudentInfo(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/student/delete")
    Call<BaseBean<Boolean>> deleteStudent(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/myHomework")
    Call<BaseBean<HomeworkListBean>> getHomeworkList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/homework/submit/detail")
    Call<BaseBean<HomeworkDetailBean>> getHomeworkDetail(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/homework/parent/submit")
    Call<BaseBean<Integer>> submitHomework(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/homework/scoreList")
    Call<BaseBean<HomeworkScoreListBean>> getHomeworkScoreList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/homework/save")
    Call<BaseBean<Integer>> publishHomework(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/homework/teacher/revert")
    Call<BaseBean<Boolean>> revertHomework(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/homework/teacher/submit")
    Call<BaseBean<Boolean>> correctHomework(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/homework/recommendList")
    Call<BaseBean<List<HomeworkDetailBean>>> recommendList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/todayList")
    Call<BaseBean<List<TodayCourseBean>>> getTodayList(@Header("token") String token) throws ClientException;

    @POST("/api/campus/course/v2.0/myGradeClass")
    Call<BaseBean<List<MyGradeClassBean>>> getMyGradeClass(@Header("token") String token) throws ClientException;

    @POST("/api/campus/school/v2.0/department/list")
    Call<BaseBean<List<DepartmentBean>>> getDepartmentList(@Header("token") String token) throws ClientException;

    @POST("/api/campus/school/v2.0/save")
    Call<BaseBean<Integer>> saveSchool(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/school/v2.0/department/save")
    Call<BaseBean<Integer>> saveDepartment(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/feedback/v2.0/save")
    Call<BaseBean<Boolean>> feedback(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/xuedou/detail")
    Call<BaseBean<XuedouDetailBean>> xuedouDetail(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/xuedou/collect")
    Call<BaseBean<XuedouDetailBean>> xuedouCollect(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/oss/v2.0/genCredential")
    Call<BaseBean<GenCredentialBean>> getGenCredential(@Header("token") String token) throws ClientException;

    @POST("/api/campus/user/v2.0/student/action/add")
    Call<BaseBean<Integer>> addAction(@Header("token") String token, @Body RequestBody body) throws ClientException;
}
