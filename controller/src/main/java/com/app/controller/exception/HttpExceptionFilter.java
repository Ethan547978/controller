package com.app.controller.exception;

import android.text.TextUtils;


import com.app.controller.bean.BaseBean;
import com.app.library.utils.LogUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import retrofit2.Response;


/**
 * Description : http错误信息过滤器
 * Creator : ZST
 * Data : 2017/8/25.
 */
public class HttpExceptionFilter<T> {

    private static class SingletonHolder {
        public static final HttpExceptionFilter INSTANCE = new HttpExceptionFilter();
    }

    public static HttpExceptionFilter getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static final Map<Integer, HttpException> mExceptionMaps = new ConcurrentHashMap<>();


    /* ----异常状态码start----*/
    private static final int PARAMS_EXCEPTION = 10000;//无权限
    
    private static final int NOT_REGISTER = 30004;//手机号尚未注册
    /* ----异常状态码end----*/


    /* ----公用错误信息----*/
    private HttpExceptionFilter() {
        mExceptionMaps.put(PARAMS_EXCEPTION,new HttpException(PARAMS_EXCEPTION, "参数检测异常"));
        mExceptionMaps.put(NOT_REGISTER, new HttpException(NOT_REGISTER, "手机号尚未注册"));
    }


    public HttpException filter(Response response) {

        if (response == null || response.errorBody() == null) {
            return getDefaultHttpException();
        }

        int statusCode = response.code();
        String errorMessage = response.message();
        LogUtils.d("HttpException", "http exception :" + statusCode);

        if (TextUtils.isEmpty(errorMessage)) {
            return getDefaultHttpException();
        }

        HttpException exception = mExceptionMaps.get(statusCode);
        if (exception == null) {
            exception = new HttpException(statusCode, errorMessage);
        }
        return exception;
    }

    /**
     * 接口返回状态异常处理
     * @param baseBean 返回的状态bean
     * @return HttpException
     */
    public HttpException filterRes(BaseBean<T> baseBean) {

        if (baseBean == null ) {
            return getDefaultHttpException();
        }

        int statusCode = baseBean.getCode();
        String errorMessage = baseBean.getMsg();
        LogUtils.d("HttpException", "http exception :" + statusCode);

        if (TextUtils.isEmpty(errorMessage)) {
            return getDefaultHttpException();
        }

        HttpException exception = mExceptionMaps.get(statusCode);
        if (exception == null) {
            exception = new HttpException(statusCode, errorMessage);
        }
        return exception;
    }

    public HttpException getDefaultHttpException() {
        return new HttpException(0, "您的网络连接失败,请检查网络");
    }
}
