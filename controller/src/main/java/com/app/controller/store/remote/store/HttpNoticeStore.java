package com.app.controller.store.remote.store;

import com.app.controller.bean.BaseBean;
import com.app.controller.bean.NoticeDetailBean;
import com.app.controller.bean.NoticeListBean;
import com.app.controller.exception.ClientException;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface HttpNoticeStore {
    String BASE_URL = "http://47.115.140.192:8763";

    @POST("/api/campus/school/v2.0/notice/list")
    Call<BaseBean<NoticeListBean>> getNoticeList(@Header("token") String token, @Body RequestBody body) throws ClientException;

    @POST("/api/campus/school/v2.0/notice/detail")
    Call<BaseBean<NoticeDetailBean>> getNoticeDetail(@Header("token") String token, @Body RequestBody body) throws ClientException;
}
