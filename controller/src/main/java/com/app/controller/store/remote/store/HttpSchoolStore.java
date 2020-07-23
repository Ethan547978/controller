package com.app.controller.store.remote.store;

import com.app.controller.bean.BaseBean;
import com.app.controller.bean.GetVisitorListBean;
import com.app.controller.exception.ClientException;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface HttpSchoolStore {
    String BASE_URL = "http://47.115.140.192:8763";

    /**
     *
     * @throws ClientException
     */
    @POST("/api/campus/visitor/v2.0/list")
    Call<BaseBean<GetVisitorListBean>> getVisitorList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    /**
     *
     * @throws ClientException
     */
    @POST("/api/campus/visitor/v2.0/save")
    Call<BaseBean<Integer>> saveVisitor(@Header("token") String token, @Body RequestBody body) throws ClientException;

    /**
     *
     * @throws ClientException
     */
    @POST("/api/campus/visitor/v2.0/status")
    Call<BaseBean<Object>> editVisitorState(@Header("token") String token, @Body RequestBody body) throws ClientException;

}
