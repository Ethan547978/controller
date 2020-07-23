package com.app.controller.store.remote.store;

import com.app.controller.bean.BaseBean;
import com.app.controller.bean.GenCredentialBean;
import com.app.controller.exception.ClientException;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface HttpUploadStore {
    String BASE_URL = "http://47.115.140.192:8763";

    @POST("/api/campus/oss/v2.0/genCredential")
    Call<BaseBean<GenCredentialBean>> getGenCredential(@Header("token") String token) throws ClientException;

}
