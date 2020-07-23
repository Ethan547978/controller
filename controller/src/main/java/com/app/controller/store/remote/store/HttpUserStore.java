package com.app.controller.store.remote.store;


import com.app.controller.bean.BaseBean;
import com.app.controller.bean.LoginBean;
import com.app.controller.exception.ClientException;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Description : 用户业务接口类
 * Creator : ZST
 * Data : 2017/8/25.
 */
public interface HttpUserStore {

    String BASE_URL = "http://47.115.140.192:8763";

    /**
     * 手机登录
     */
//    @FormUrlEncoded
////    @Headers({"Content-type:application/json;charset=UTF-8"})
//    @POST("/api/campus/user/v2.0/login")
//    Call<BaseBean<LoginBean>> login(@Field("type") int type, @Field("mobile") String mobile,@Field("code") String code, @Field("password") String password) throws ClientException;
//    @FormUrlEncoded
//    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/api/campus/user/v2.0/login")
    Call<BaseBean<LoginBean>> login(@Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/register")
    Call<BaseBean<Boolean>> register(@Header("token") String token,@Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/logout")
    Call<BaseBean<Boolean>> logout(@Header("token") String token) throws ClientException;

    @POST("/api/campus/user/v2.0/sendCode")
    Call<BaseBean<Boolean>> sendCode(@Header("token") String token,@Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/changePassword")
    Call<BaseBean<Boolean>> changePassword(@Header("token") String token,@Body RequestBody body) throws ClientException;

    @POST("/api/campus/user/v2.0/changePassword2")
    Call<BaseBean<Boolean>> changePassword2(@Header("token") String token,@Body RequestBody body) throws ClientException;

}
