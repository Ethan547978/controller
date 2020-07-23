package com.app.controller.store.local.cache;


import com.app.controller.exception.CacheException;

public interface ICache {
    <T> T getCache(String key, Class<T> clazz) throws CacheException;

    void putCache(String key, Object obj) throws CacheException;

    void deleteCache(String key) throws CacheException;

    <T> T getCacheQuietly(String key, Class<T> clazz);

    void putCacheQuietly(String key, Object obj);

    void deleteCacheQuietly(String key);

    void release();
}
