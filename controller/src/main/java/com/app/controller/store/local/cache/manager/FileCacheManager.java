package com.app.controller.store.local.cache.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.app.controller.store.local.cache.SimpleDiskCache;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Description : 文件缓存
 * Creator : ZST
 * Data : 2017/8/25.
 */
public class FileCacheManager {

    private SimpleDiskCache cache;

    public FileCacheManager(File cacheDir, int maxSize) {
        try {
            cache = SimpleDiskCache.open(cacheDir, 1, maxSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if an object with the given key exists in the Reservoir.
     *
     * @param key the key string.
     * @return true if object with given key exists.
     */
    public boolean contains(String key) throws Exception {
        return cache.contains(key);
    }

    /**
     * Put an object into Reservoir with the given key. This a blocking IO
     * operation. Previously stored object with the same key (if any) will be
     * overwritten.
     *
     * @param key    the key string.
     * @param object the object to be stored.
     */
    public void put(String key, Object object) throws Exception {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String json = gson.toJson(object);
        cache.put(key, json);
    }

    /**
     * Get an object from Reservoir with the given key. This a blocking IO
     * operation.
     *
     * @param key      the key string.
     * @param classOfT the Class type of the expected return object.
     * @return the object of the given type if it exists.
     */
    public <T> T get(String key, Class<T> classOfT) throws Exception {

        SimpleDiskCache.StringEntry entry = cache.getString(key);
        if (entry == null) {
            throw new NullPointerException("缓存中没有 " + classOfT.getName() + " 数据");
        }

        String json = entry.getString();
        T value = new Gson().fromJson(json, classOfT);
        if (value == null)
            throw new NullPointerException("数据转JSON异常");
        return value;
    }

    /**
     * Get an object from Reservoir with the given key. This a blocking IO
     * operation.
     *
     * @param key     the key string.
     * @param typeOfT the Class type of the expected return object.
     * @return the object of the given type if it exists.
     */
    public <T> T get(String key, Type typeOfT) throws Exception {

        String json = cache.getString(key).getString();
        T value = new Gson().fromJson(json, typeOfT);
        if (value == null)
            throw new NullPointerException();
        return value;
    }

    /**
     * Delete an object from Reservoir with the given key. This a blocking IO
     * operation. Previously stored object with the same key (if any) will be
     * deleted.
     *
     * @param key the key string.
     */
    public void delete(String key) throws Exception {
        cache.delete(key);
    }

    public String getValueString(String key) {
        String json = null;
        try {
            json = cache.getString(key).getString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public void putString(String key, String value) throws Exception {
        cache.put(key, value);
    }
}
