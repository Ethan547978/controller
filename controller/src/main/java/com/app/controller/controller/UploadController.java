package com.app.controller.controller;

import android.text.TextUtils;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.CannedAccessControlList;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.alibaba.sdk.android.oss.model.CreateBucketResult;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.app.controller.CommonModule;
import com.app.controller.account.AccountManager;
import com.app.controller.bean.GenCredentialBean;
import com.app.controller.controller.core.BaseControllers;
import com.app.controller.controller.core.Controller;
import com.app.controller.controller.core.ControllerCacheParams;
import com.app.controller.controller.core.ControllerRunnable;
import com.app.controller.controller.core.Listener;
import com.app.controller.store.remote.store.HttpUploadStore;
import com.app.library.executor.MainThreadExecutor;
import com.app.library.utils.LogUtils;
import com.app.library.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UploadController extends BaseControllers {

    private OSS oss;
    private GenCredentialBean bean;
    private String filePath;
    private String curObjectKey;
    private String finalUrls;//上传完返回的Url
    private String curUploadPath;
    private ArrayList<String> uploadFilePaths = new ArrayList<>();//本地文件路径
    private UploadListener uploadListener;

    private UploadController() {
    }

    private static class SingletonHolder {
        public static final UploadController INSTANCE = new UploadController();
    }

    public static UploadController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public interface UploadListener {
        void onSuccess(String imgUrls);

        void onFailure();
    }

    //获取STS临时令牌
    public Controller getGenCredential(final Listener<GenCredentialBean> listener) {
        return runDataController(new ControllerCacheParams(false, false, "getGenCredential"), listener, new ControllerRunnable<GenCredentialBean>() {
            @Override
            public GenCredentialBean run(Controller controller) {
                return runData(getProtocol(HttpUploadStore.class).getGenCredential(AccountManager.getInstance().getLoginAccount().getToken()));
            }
        });
    }

    /**
     * @param bean
     * @param filePath       文件上传路径(FileUploadPath.java)
     * @param localFilePath  本地文件路径，多个文件以逗号隔开
     * @param uploadListener
     */
    public void uploadPhoto(GenCredentialBean bean, String filePath, String localFilePath, UploadListener uploadListener) {
        uploadFilePaths.clear();
        finalUrls = "";
        curObjectKey = "";

        this.bean = bean;
        this.filePath = filePath;
        this.uploadListener = uploadListener;

        if (localFilePath.contains(",")) {
            List<String> temp = Arrays.asList(localFilePath.split(","));
            for (String s : temp) {
                uploadFilePaths.add(StringUtils.replaceFileSuffix(s));
            }
        } else {
            uploadFilePaths.add(StringUtils.replaceFileSuffix(localFilePath));
        }

        initOSS();
    }

    private String getObjectKey() {
        String suffix = curUploadPath.substring(curUploadPath.lastIndexOf("."));
        return curObjectKey = filePath + System.currentTimeMillis() + suffix;
    }

    private void initOSS() {
//        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
//        String stsServer = "STS应用服务器地址，例如http://abc.com";
        // 推荐使用OSSAuthCredentialsProvider。token过期可以及时更新。
//        OSSCredentialProvider credentialProvider = new OSSAuthCredentialsProvider(stsServer);
        OSSCredentialProvider credentialProvider = new OSSStsTokenCredentialProvider(bean.getAccessKeyId(), bean.getAccessKeySecret(), bean.getAccessKeyToken());
        // 配置类如果不设置，会有默认配置。
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒。
        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒。
        conf.setMaxConcurrentRequest(5); // 最大并发请求数，默认5个。
        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次。
        oss = new OSSClient(CommonModule.getApplication(), bean.getEndPoint(), credentialProvider);
        OSSLog.enableLog();  //调用此方法即可开启日志
        checkUpload();
    }


    private void checkUpload() {
        if (!uploadFilePaths.isEmpty()) {
            curUploadPath = uploadFilePaths.get(0);
            uploadFilePaths.remove(0);
            asyncPut(curUploadPath);
        } else {
            if (uploadListener != null) {
                callSuccess();
            }
        }
    }

    /**
     * 上传文件
     */
    private void asyncPut(String path) {
        // 构造上传请求。
        PutObjectRequest put = new PutObjectRequest(bean.getBucket(), getObjectKey(), path);
        // 异步上传时可以设置进度回调。
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                LogUtils.d("PutObject", "currentSize: " + currentSize + " totalSize: " + totalSize);
            }
        });

        OSSAsyncTask task = oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                LogUtils.d("PutObject", "UploadSuccess");
                LogUtils.d("ETag", result.getETag());
                LogUtils.d("RequestId", result.getRequestId());
                LogUtils.d("RequestId", result.toString());

                String url = bean.getBucketDomain() + "/" + curObjectKey;
                if (TextUtils.isEmpty(finalUrls)) {
                    finalUrls = url;
                } else {
                    finalUrls += "," + url;
                }
                LogUtils.d("finalUrls", url);
                checkUpload();
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                if (clientExcepion != null) {
                    clientExcepion.printStackTrace();// 本地异常，如网络异常等。
                }
                if (serviceException != null) {// 服务异常。
                    LogUtils.e("ErrorCode", serviceException.getErrorCode());
                    LogUtils.e("RequestId", serviceException.getRequestId());
                    LogUtils.e("HostId", serviceException.getHostId());
                    LogUtils.e("RawMessage", serviceException.getRawMessage());
                }
                callFailure();
            }
        });
        // task.cancel(); // 可以取消任务。
        // task.waitUntilFinished(); // 等待上传完成。
    }

    private void callSuccess() {
        if (uploadListener != null) {
            MainThreadExecutor.getInstance().execute(() -> {
                if (uploadListener != null) {
                    uploadListener.onSuccess(finalUrls);
                }
            });
        }
    }

    private void callFailure() {
        if (uploadListener != null) {
            MainThreadExecutor.getInstance().execute(() -> {
                if (uploadListener != null) {
                    uploadListener.onFailure();
                }
            });
        }
    }

    /**
     * 创建存储空间
     */
    private void creatBucket() {
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(bean.getBucket());
        // 设置存储空间的访问权限为公共读，默认为私有读写。
        createBucketRequest.setBucketACL(CannedAccessControlList.PublicRead);
        // 指定存储空间所在的地域。
//        createBucketRequest.setLocationConstraint("oss-cn-hangzhou");
        OSSAsyncTask createTask = oss.asyncCreateBucket(createBucketRequest, new OSSCompletedCallback<CreateBucketRequest, CreateBucketResult>() {
            @Override
            public void onSuccess(CreateBucketRequest request, CreateBucketResult result) {
                LogUtils.d("locationConstraint", request.getLocationConstraint());
            }

            @Override
            public void onFailure(CreateBucketRequest request, ClientException clientException, ServiceException serviceException) {
                // 请求异常。
                if (clientException != null) {
                    // 本地异常，如网络异常等。
                    clientException.printStackTrace();
                }
                if (serviceException != null) {
                    // 服务异常。
                    LogUtils.e("ErrorCode", serviceException.getErrorCode());
                    LogUtils.e("RequestId", serviceException.getRequestId());
                    LogUtils.e("HostId", serviceException.getHostId());
                    LogUtils.e("RawMessage", serviceException.getRawMessage());
                }
                uploadListener.onFailure();
            }
        });
    }


}
