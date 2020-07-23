package com.app.controller.store.remote.store;

import com.app.controller.bean.BaseBean;
import com.app.controller.bean.ClassInfo;
import com.app.controller.bean.CourseListBean;
import com.app.controller.bean.GoodListBean;
import com.app.controller.bean.LessonPageBean;
import com.app.controller.bean.MyCourseListBean;
import com.app.controller.bean.RecommendListBean;
import com.app.controller.exception.ClientException;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface HttpCourseStore {
    String BASE_URL = "http://47.115.140.192:8763";

    @POST("/api/campus/course/v2.0/list")
    Call<BaseBean<List<CourseListBean>>> getCourseList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/myList")
    Call<BaseBean<List<MyCourseListBean>>> getMyCourseList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/online/list")
    Call<BaseBean<LessonPageBean>> getOnlineList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/online/save")
    Call<BaseBean<Integer>> saveCourse(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/save")
    Call<BaseBean<Integer>> saveCourseTable(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/online/read")
    Call<BaseBean<Integer>> readCourse(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/courseClass")
    Call<BaseBean<List<ClassInfo>>> courseClass(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/homework/goodList")
    Call<BaseBean<GoodListBean>> goodList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/course/v2.0/homework/recommendList2")
    Call<BaseBean<RecommendListBean>> getRecommendList2(@Header("token") String token, @Body RequestBody body) throws ClientException;
}
