package com.app.controller.store.remote;
import android.text.TextUtils;
import android.util.Log;

import com.app.controller.account.AccountManager;
import com.app.controller.controller.CustomOKHttpLoggingInterceptor;
import com.app.library.executor.MainThreadExecutor;
import com.app.library.utils.LogUtils;
import com.app.library.utils.StringUtils;
import com.app.controller.CommonModule;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description : 网络请求Store
 * Creator : ZST
 * Data : 2017/8/25.
 */
public class HttpStoreManager {

    private static final String TAG = "HttpStoreManager";

    private static class SingletonHolder {
        private static final HttpStoreManager INSTANCE = new HttpStoreManager();
    }

    public static HttpStoreManager getInstance() {
        return HttpStoreManager.SingletonHolder.INSTANCE;
    }

    private final OkHttpClient mOkHttpClient;

    private HttpStoreManager() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient().newBuilder();
        okHttpClientBuilder.retryOnConnectionFailure(true);//错误重连
        okHttpClientBuilder.addInterceptor(new HttpRequestInterceptor());
//        okHttpClientBuilder.addInterceptor(makeLoggingInterceptor());
        okHttpClientBuilder.addInterceptor(makeCusLoggingInterceptor());
        okHttpClientBuilder.connectTimeout(5, TimeUnit.SECONDS).readTimeout(5, TimeUnit.SECONDS).writeTimeout(5, TimeUnit.SECONDS);
        mOkHttpClient = okHttpClientBuilder.build();
    }

    public <T> T getProtocol(Class<T> clazz) {
        String baseUrl = "http://47.115.140.192:8763";
        try {
            /*用反射去获取自定义HttpStore中的BASE_URL字段;
              约定: 新建一个HttpStore的时候一定要有BASE_URL字段并赋值*/
            Field field1 = clazz.getField("BASE_URL");
            String reflectUrl = (String) field1.get(clazz);
            if (!StringUtils.isEmpty(reflectUrl)) {
                baseUrl = reflectUrl;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.getMessage();
            e.printStackTrace();
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .callbackExecutor(MainThreadExecutor.getInstance())
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient)
                .build();

        return retrofit.create(clazz);
    }

    private static HttpLoggingInterceptor makeLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtils.d(message);
            }
        });
        logging.setLevel(CommonModule.isDebug ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);
        return logging;
    }

    private static CustomOKHttpLoggingInterceptor makeCusLoggingInterceptor() {
        CustomOKHttpLoggingInterceptor logging = new CustomOKHttpLoggingInterceptor(new CustomOKHttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(TAG, message);
            }
        });
        logging.setLevel(CommonModule.isDebug ? CustomOKHttpLoggingInterceptor.Level.BODY
                : CustomOKHttpLoggingInterceptor.Level.NONE);
        return logging;
    }

    /**
     * 通用参数拦截器
     */
    private class HttpRequestInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request original = chain.request();
            HttpUrl.Builder builder = original.url().newBuilder();

            if (!TextUtils.isEmpty(AccountManager.getInstance().getLoginAccount().getToken())) {
                builder.addQueryParameter("token", AccountManager.getInstance().getLoginAccount().getToken());
            }
//            builder.addQueryParameter("uid",String.valueOf(AccountManager.getInstance().getLoginAccount().getUid()));

            HttpUrl url = builder.build();
            Request request = chain.request().newBuilder().addHeader("deviceType","1").url(url).build();
            return chain.proceed(request);//执行此次请求;
        }
    }
}
