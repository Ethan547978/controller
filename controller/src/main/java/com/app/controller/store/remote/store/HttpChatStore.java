package com.app.controller.store.remote.store;


import com.app.controller.bean.BaseBean;
import com.app.controller.bean.ChatStudentInfo;
import com.app.controller.bean.ChatTeacherInfo;
import com.app.controller.bean.ContactInfoBean;
import com.app.controller.exception.ClientException;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface HttpChatStore {

    String BASE_URL = "http://47.115.140.192:8763";

    @POST("/api/campus/user/v2.0/im/list")
    Call<BaseBean<List<ContactInfoBean>>> getContactList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/student/im")
    Call<BaseBean<ChatStudentInfo>> getStudentInfo(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/teacher/im")
    Call<BaseBean<ChatTeacherInfo>> getTeacherInfo(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/im/detail")
    Call<BaseBean<ContactInfoBean>> getUserInfo(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/im/detail/list")
    Call<BaseBean<List<ContactInfoBean>>> getImUserList(@Header("token") String token, @Body RequestBody body) throws ClientException;
}
