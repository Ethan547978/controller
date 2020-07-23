package com.app.controller.store.remote.store;

import com.app.controller.bean.BaseBean;
import com.app.controller.bean.ContrabandBean;
import com.app.controller.bean.ContrabandListBean;
import com.app.controller.bean.ContrabandVisitorBean;
import com.app.controller.bean.ContrabandVisitorListBean;
import com.app.controller.exception.ClientException;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface HttpContrabandStore {
    String BASE_URL = "http://47.115.140.192:8763";

    /**
     */
    @POST("/api/campus/contraband/v2.0/findStudents")
    Call<BaseBean<ContrabandBean>> findStudents(@Header("token") String token, @Body RequestBody body) throws ClientException;

    /**
     */
    @POST("/api/campus/contraband/v2.0/findVisitors")
    Call<BaseBean<ContrabandVisitorBean>> findVisitors(@Header("token") String token, @Body RequestBody body) throws ClientException;


    /**
     */
    @POST("/api/campus/contraband/v2.0/dealStudent")
    Call<BaseBean<Object>> dealStudent(@Header("token") String token, @Body RequestBody body) throws ClientException;


    /**
     */
    @POST("/api/campus/contraband/v2.0/dealVisitor")
    Call<BaseBean<Object>> dealVisitor(@Header("token") String token, @Body RequestBody body) throws ClientException;

    /**
     */
    @POST("/api/campus/contraband/v2.0/saveStudent")
    Call<BaseBean<Object>> saveStudent(@Header("token") String token, @Body RequestBody body) throws ClientException;

    /**
     */
    @POST("/api/campus/contraband/v2.0/saveVisitor")
    Call<BaseBean<Object>> saveVisitor(@Header("token") String token, @Body RequestBody body) throws ClientException;

    /**
     */
    @POST("/api/campus/contraband/v2.0/getStudent")
    Call<BaseBean<ContrabandListBean>> getContrabandStudent(@Header("token") String token, @Body RequestBody body) throws ClientException;

    /**
     */
    @POST("/api/campus/contraband/v2.0/getVisitor")
    Call<BaseBean<ContrabandVisitorListBean>> getContrabandVisitor(@Header("token") String token, @Body RequestBody body) throws ClientException;


}
