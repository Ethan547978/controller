package com.app.controller.store.local.cache;


import com.app.controller.exception.CacheException;
import com.app.controller.store.local.cache.manager.FileCacheManager;

public class FileCache implements ICache {

    private FileCacheManager mFileCacheManager;

    public FileCache(FileCacheManager fileCacheManager) {
        mFileCacheManager = fileCacheManager;
    }

    @Override
    public <T> T getCache(String key, Class<T> clazz) throws CacheException {
        try {
            return mFileCacheManager.get(key, clazz);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    @Override
    public void putCache(String key, Object obj) throws CacheException {
        try {
            mFileCacheManager.put(key, obj);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    @Override
    public void deleteCache(String key) throws CacheException {
        try {
            mFileCacheManager.delete(key);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    @Override
    public <T> T getCacheQuietly(String key, Class<T> clazz) {
        try {
            return mFileCacheManager.get(key, clazz);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void putCacheQuietly(String key, Object obj) {
        try {
            mFileCacheManager.put(key, obj);
        } catch (Exception e) {
        }
    }

    @Override
    public void deleteCacheQuietly(String key) {
        try {
            mFileCacheManager.delete(key);
        } catch (Exception e) {
        }
    }

    @Override
    public void release() {
        mFileCacheManager = null;
    }
}
