package com.app.controller.store.local.cache.manager;

import com.app.controller.account.Account;
import com.app.controller.exception.ClientException;
import com.app.controller.store.local.cache.BeanCache;
import com.app.controller.store.local.cache.CacheResult;
import com.app.controller.utils.GsonUtils;
import com.app.library.utils.LogUtils;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Description : http缓存
 * Creator : ZST
 * Data : 2017/8/25.
 */
public class HttpCacheStoreManager {
    private Account mAccount;
    private BeanCache mBeanCache;
    private FileCacheManager mHttpFileCacheManager;
    private MemoryCacheManager mHttpMemoryCacheManager;

    public HttpCacheStoreManager(Account account) {
        mAccount = account;
        mBeanCache = new BeanCache(getFileCacheManager(), getMemoryCacheManager());
    }

    public synchronized <T> CacheResult<T> getCache(Class<T> clazz, String key, Object... params) {
        try {
            JSONObject jsonObject = new JSONObject();
            List<Object> allArgs = new ArrayList<>();
            addParams(allArgs, params);

            jsonObject.put("key", clazz.getName() + key);
            for (int i = 0; i < allArgs.size(); i++) {
                jsonObject.put("key_" + i, allArgs.get(i).toString());
            }

            return mBeanCache.getCache(jsonObject.toString(), clazz);
        } catch (Exception e) {
            return null;
        }
    }

    public synchronized <T> CacheResult<T> getMemoryCache(Class<T> clazz, String key, Object... params) {
        try {
            JSONObject jsonObject = new JSONObject();
            List<Object> allArgs = new ArrayList<>();
            addParams(allArgs, params);

            jsonObject.put("key", clazz.getName() + key);
            for (int i = 0; i < allArgs.size(); i++) {
                jsonObject.put("key_" + i, allArgs.get(i).toString());
            }

            return mBeanCache.getMemoryCache(jsonObject.toString(), clazz);
        } catch (Exception e) {
            return null;
        }
    }

    public synchronized <T> CacheResult<T> getFileCache(Class<T> clazz, String key, Object... params) {
        try {
            JSONObject jsonObject = new JSONObject();
            List<Object> allArgs = new ArrayList<>();
            addParams(allArgs, params);

            jsonObject.put("key", clazz.getName() + key);
            for (int i = 0; i < allArgs.size(); i++) {
                jsonObject.put("key_" + i, allArgs.get(i).toString());
            }

            CacheResult<T> result = mBeanCache.getFileCache(jsonObject.toString(), clazz);
            LogUtils.d("demo", "getFileCache--->" + jsonObject.toString());
            LogUtils.d("demo", "getFileCache--->" + GsonUtils.getInstance().parseIfNull(result.result));
            return result;
        } catch (Exception e) {
            if (e instanceof ClientException) {
                if (((ClientException) e).getException() != null) {
                    ((ClientException) e).getException().printStackTrace();
                }
            }
            return null;
        }
    }

    public synchronized <T> void saveCache(T result, String key, Object... params) {
        if (result == null) {
            return;
        }

        try {
            result = (T) checkNullList(result);

            JSONObject jsonObject = new JSONObject();
            List<Object> allArgs = new ArrayList<>();
            addParams(allArgs, params);

            jsonObject.put("key", result.getClass().getName() + key);
            for (int i = 0; i < allArgs.size(); i++) {
                jsonObject.put("key_" + i, allArgs.get(i).toString());
            }

            LogUtils.d("demo", "start saveCache--->" + jsonObject.toString());
            mBeanCache.putCache(jsonObject.toString(), result);
            LogUtils.d("demo", "saveCache--->" + jsonObject.toString());
            LogUtils.d("demo", "saveCache--->" + GsonUtils.getInstance().parseIfNull(result));
        } catch (Exception e) {
        }
    }

    public synchronized <T> void clearCache(Class<T> clazz, String key, Object... params) {
        try {
            JSONObject jsonObject = new JSONObject();
            List<Object> allArgs = new ArrayList<>();
            addParams(allArgs, params);

            jsonObject.put("key", clazz.getName() + key);
            for (int i = 0; i < allArgs.size(); i++) {
                jsonObject.put("key_" + i, allArgs.get(i).toString());
            }

            mBeanCache.deleteCache(jsonObject.toString());
        } catch (Exception e) {
        }
    }

    public FileCacheManager getFileCacheManager() {
        if (mHttpFileCacheManager == null) {
            mHttpFileCacheManager = new FileCacheManager(mAccount.getFileStoreManager().getHttpCacheDir(), 1024);
        }
        return mHttpFileCacheManager;
    }


    public MemoryCacheManager getMemoryCacheManager() {
        if (mHttpMemoryCacheManager == null) {
            mHttpMemoryCacheManager = MemoryCacheManager.getInstance();
        }
        return mHttpMemoryCacheManager;
    }

    private static Object checkNullList(Object object) {
        if (object != null) {
            Field[] fields = object.getClass().getDeclaredFields();
            for (int j = 0; j < fields.length; j++) {
                try {
                    Field field = fields[j];
                    field.setAccessible(true);
                    Class<?> clazz = field.getType();
                    if (!clazz.isPrimitive()) {
                        Object obj = field.get(object);
                        if (obj == null) {
                            if (clazz == List.class) {
                                field.set(object, new ArrayList<>());
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        }

        return object;
    }

    private static void addParams(List<Object> allArgsList, Object arg) {
        if (arg != null) {
            if (arg instanceof Object[]) {
                Object[] argObject = (Object[]) arg;
                if (argObject.length > 0) {
                    for (int j = 0; j < argObject.length; j++) {
                        addParams(allArgsList, argObject[j]);
                    }
                }
            } else {
                allArgsList.add(arg);
            }
        }
    }
}
