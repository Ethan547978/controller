package com.app.controller.controller.core;

import com.app.controller.account.Account;
import com.app.controller.account.AccountManager;
import com.app.controller.bean.BaseBean;
import com.app.controller.exception.ClientException;
import com.app.controller.exception.HttpExceptionFilter;
import com.app.controller.store.local.cache.CacheResult;
import com.app.controller.store.remote.HttpStoreManager;
import com.app.library.executor.AsyncExecutor;
import com.app.library.executor.AsyncQueueExecutor;
import com.app.library.executor.AsyncQueueExecutorWithDB;
import com.app.library.executor.AsyncQueueExecutorWithHttp;
import com.app.library.executor.AsyncQueueExecutorWithIO;
import com.app.library.executor.MainThreadExecutor;
import com.app.library.utils.AndroidUtils;
import com.app.library.utils.LogUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.Response;


/**
 * Description : Controller基类
 * Creator : ZST
 * Data : 2017/8/25.
 */
public abstract class BaseControllers {
    private static final String SAFETAG = "Safe";

    protected final void callStart(final Controller controller) {
        runToMainThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Listener<?> listener = controller != null ? controller.getListener() : null;
                    if (listener != null) {
                        listener.onStart(controller);
                    }
                } catch (Exception e) {
                    LogUtils.d(SAFETAG, getClass().getSimpleName() + " callStart Error!!!!!!", e);
                }
            }
        });
    }

    protected final <R> void callCacheComplete(final Controller controller, final R result, final Object... otherResult) {
        runToMainThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Listener<R> listener = controller != null ? ((Listener<R>) controller.getListener()) : null;
                    if (listener != null) {
                        listener.onCacheComplete(controller, result);
                    }
                } catch (Exception e) {
                    LogUtils.d(SAFETAG, getClass().getSimpleName() + " callCacheComplete Error!!!!!!", e);
                }
            }
        });
    }

    protected final <R> void callCacheFail(final Controller controller) {
        runToMainThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Listener<R> listener = controller != null ? ((Listener<R>) controller.getListener()) : null;
                    if (listener != null) {
                        listener.onCacheFail(controller);
                    }
                } catch (Exception e) {
                    LogUtils.d(SAFETAG, getClass().getSimpleName() + " callCacheFail Error!!!!!!", e);
                }
            }
        });
    }

    protected final <R> void callProgress(final Controller controller, final ProgressListener progressListener, final float progress) {
        runToMainThread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (progressListener != null) {
                        progressListener.onProgress(controller, progress);
                    }
                } catch (Exception e) {
                    LogUtils.d(SAFETAG, getClass().getSimpleName() + " callProgress Error!!!!!!", e);
                }
            }
        });
    }

    protected final <R> void callNext(final Controller controller, final R result, final Object... otherResult) {
        runToMainThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Listener<R> listener = controller != null ? ((Listener<R>) controller.getListener()) : null;
                    if (listener != null) {
                        listener.onNext(controller, result);
                    }
                } catch (Exception e) {
                    LogUtils.d(SAFETAG, getClass().getSimpleName() + " callNext Error!!!!!!", e);
                }
            }
        });
    }

    protected final <R> void callComplete(final Controller controller) {
        runToMainThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Listener<R> listener = controller != null ? ((Listener<R>) controller.getListener()) : null;
                    if (listener != null) {
                        listener.onComplete(controller);
                    }
                } catch (Exception e) {
                    LogUtils.d(SAFETAG, getClass().getSimpleName() + " callComplete Error!!!!!!", e);
                }
            }
        });
    }

    protected final void callError(final Controller controller, final ClientException error) {
        if (error != null && error.getException() != null) {
            error.getException().printStackTrace();
        }

        runToMainThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Listener<?> listener = controller != null ? controller.getListener() : null;
                    if (listener != null) {
                        listener.onError(controller, error);
                    }
                } catch (Exception e) {
                    LogUtils.d(SAFETAG, getClass().getSimpleName() + " callError Error!!!!!!", e);
                }
            }
        });
    }

    protected <T> T getProtocol(Class<T> clazz) {
        return HttpStoreManager.getInstance().getProtocol(clazz);
    }

    protected <T> T runData(Call<BaseBean<T>> call) {
        if (call == null) {
            return null;
        }
        Response<BaseBean<T>> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response == null || !response.isSuccessful()) {
            throw HttpExceptionFilter.getInstance().filter(response);
        }

        BaseBean<T> baseBean = response.body();
        if (baseBean == null || baseBean.getCode() != 0) {
//        if (baseBean == null || !baseBean.isSuccess()) {
            throw HttpExceptionFilter.getInstance().filterRes(baseBean);
        }
        return baseBean.getData();
    }

    protected final void runToAsyncThread(final Runnable runnable) {
        AsyncExecutor.getInstance().execute(runnable);
    }

    protected final void runToAsyncThread(final Runnable runnable, long delayed) {
        AsyncExecutor.getInstance().executeDelayed(runnable, delayed);
    }

    protected final void runToAsyncThreadWithHttp(Runnable runnable) {
        AsyncQueueExecutorWithHttp.getInstance().execute(runnable);
    }

    protected final void runToAsyncThreadWithHttp(Runnable runnable, long delayed) {
        AsyncQueueExecutorWithHttp.getInstance().executeDelayed(runnable, delayed);
    }

    protected final void runToAsyncCommandQueue(Runnable runnable) {
        AsyncQueueExecutor.getInstance().execute(runnable);
    }

    protected final void runToAsyncCommandQueue(Runnable runnable, long delayed) {
        AsyncQueueExecutor.getInstance().executeDelayed(runnable, delayed);
    }

    protected final void runToAsyncCommandQueueWithDB(Runnable runnable) {
        AsyncQueueExecutorWithDB.getInstance().execute(runnable);
    }

    protected final void runToAsyncCommandQueueWithIO(Runnable runnable) {
        AsyncQueueExecutorWithIO.getInstance().execute(runnable);
    }

    protected final void runToAsyncCommandQueueWithIO(Runnable runnable, long delayed) {
        AsyncQueueExecutorWithIO.getInstance().executeDelayed(runnable, delayed);
    }

    protected final void runToMainThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }

        if (AndroidUtils.isMainThread()) {
            runnable.run();
        } else {
            MainThreadExecutor.getInstance().execute(runnable);
        }
    }

    public final void cancelController(Controller controller) {
        if (controller != null) {
            controller.cancelController();
        }
    }

    protected final <T> Controller runCommandController(final Account account, Listener<T> listener, final ControllerRunnable<T> runnable) {
        return runCommandController(account, listener, runnable, "操作失败");
    }

    protected final <T> Controller runCommandController(final Account account, Listener<T> listener, final ControllerRunnable<T> runnable, final String errorString) {
        final Controller controller = new Controller(account, listener);
        callStart(controller);

        runToAsyncThreadWithHttp(new Runnable() {

            @Override
            public void run() {
                try {
                    if (controller.isCancel()) {
                        return;
                    }

                    runnable.onPreRun(controller);

                    // 获取HTTP数据
                    T result = runnable.run(controller);

                    runnable.onPostRun(controller, result);

                    // 刷新界面
                    callNext(controller, result);
                    callComplete(controller);
                } catch (ClientException e) {
                    runnable.onPreError(controller, e);
                    callError(controller, e);
                } catch (Exception e) {
                    ClientException exception = new ClientException(errorString);
                    runnable.onPreError(controller, exception);
                    callError(controller, exception);
                }
            }
        });
        return controller;
    }

    protected final <T> Controller runIOController(final Account account, Listener<T> listener, final ControllerRunnable<T> runnable) {
        final Controller controller = new Controller(account, listener);
        callStart(controller);

        runToAsyncCommandQueueWithIO(new Runnable() {

            @Override
            public void run() {
                try {
                    runnable.onPreRun(controller);

                    // 获取IO数据
                    T result = runnable.run(controller);

                    if (result == null) {
                        callCacheFail(controller);
                    } else {
                        runnable.onPostRun(controller, result);
                        // 刷新界面
                        callCacheComplete(controller, result);
                    }

                } catch (ClientException e) {
                    runnable.onPreError(controller, e);
                    callError(controller, e);
                } catch (Exception e) {
                    ClientException exception = new ClientException(e);
                    runnable.onPreError(controller, exception);
                    callError(controller, exception);
                }
            }
        });
        return controller;
    }

    protected final <T> Controller runDataController(final ControllerCacheParams cacheParams, Listener<T> listener, final ControllerRunnable<T> runnable) {
        return runDataController(cacheParams, AccountManager.getInstance().getLoginAccount(), listener, runnable, "获取数据失败");
    }

    protected final <T> Controller runDataController(final ControllerCacheParams cacheParams, final Account account, Listener<T> listener, final ControllerRunnable<T> runnable, final String errorString) {
        final Controller controller = new Controller(account, listener);
        callStart(controller);

        Class<T> returnType = null;
        try {
            Method runMethod = runnable.getClass().getMethod("run", Controller.class);
            returnType = (Class<T>) runMethod.getReturnType();
        } catch (Exception e) {
        }

        final Class<T> finalReturnType = returnType;
        final AtomicBoolean isCallCache = new AtomicBoolean(false);
        //需要获取缓存的情况下， 先判断是否有内存缓存，成功则回调给callCacheComplete
        if (finalReturnType != null && cacheParams != null && cacheParams.isNeedCache()) {
            CacheResult<T> cache = account.getHttpCacheStoreManager().getMemoryCache(finalReturnType, cacheParams.getCacheKey(), cacheParams.getCacheKeys());
            if (cache != null) {
                runnable.onPreCacheComplete(controller, cache.result);
                callCacheComplete(controller, cache.result);
                isCallCache.set(true);
            }
        }

        runToAsyncCommandQueueWithIO(new Runnable() {
            @Override
            public void run() {
                try {
                    if (controller.isCancel()) {
                        return;
                    }

                    //需要获取缓存的情况下，若获取不到内存缓存，则获取文件缓存，成功则回调给callCacheComplete
                    if (finalReturnType != null && !isCallCache.get() && cacheParams != null && cacheParams.isNeedCache()) {
                        CacheResult<T> cache = account.getHttpCacheStoreManager().getFileCache(finalReturnType, cacheParams.getCacheKey(), cacheParams.getCacheKeys());
                        if (cache == null) {
                            callCacheFail(controller);
                        } else {
                            runnable.onPreCacheComplete(controller, cache.result);
                            callCacheComplete(controller, cache.result);
                        }
                    }

                    runToAsyncThreadWithHttp(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                if (controller.isCancel()) {
                                    return;
                                }

                                runnable.onPreRun(controller);
                                //从网络获取数据
                                T result = runnable.run(controller);

//                                if (result == null) {
//                                    throw new ClientException(errorString);
//                                }

                                runnable.onPostRun(controller, result);

                                //刷新界面
                                callNext(controller, result);
                                callComplete(controller);

                                // 保存到缓存（内存缓存+文件缓存）
                                if (cacheParams != null && cacheParams.isSaveCache()) {
                                    account.getHttpCacheStoreManager().saveCache(result, cacheParams.getCacheKey(), cacheParams.getCacheKeys());
                                }
                            } catch (ClientException e) {
                                runnable.onPreError(controller, e);
                                callError(controller, e);
                            } catch (Exception e) {
                                e.printStackTrace();
                                ClientException exception = new ClientException(errorString);
                                runnable.onPreError(controller, exception);
                                callError(controller, exception);
                            }
                        }
                    });
                } catch (ClientException e) {
                    runnable.onPreError(controller, e);
                    callError(controller, e);
                } catch (Exception e) {
                    ClientException exception = new ClientException(errorString);
                    runnable.onPreError(controller, exception);
                    callError(controller, exception);
                }
            }
        });

        return controller;
    }
}
