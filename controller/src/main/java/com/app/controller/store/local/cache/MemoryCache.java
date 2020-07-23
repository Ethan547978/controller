package com.app.controller.store.local.cache;


import com.app.controller.exception.CacheException;
import com.app.controller.exception.ClientException;
import com.app.controller.store.local.cache.manager.MemoryCacheManager;

public class MemoryCache implements ICache {

    private MemoryCacheManager mMemoryCacheManager;

    public MemoryCache(MemoryCacheManager memoryCacheManager) {
        this.mMemoryCacheManager = memoryCacheManager;
    }

    @Override
    public <T> T getCache(String key, Class<T> clazz) throws CacheException {
        try {
            Object result = mMemoryCacheManager.get(key);
            if (result != null && clazz != null && clazz.getName().equals(result.getClass().getName())) {
                return (T) result;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    @Override
    public void putCache(String key, Object obj) throws CacheException {
        try {
            mMemoryCacheManager.save(key, obj);
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    @Override
    public void deleteCache(String key) throws CacheException {
        try {
            mMemoryCacheManager.remove(key);
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    @Override
    public <T> T getCacheQuietly(String key, Class<T> clazz) {
        try {
            return (T) mMemoryCacheManager.get(key);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void putCacheQuietly(String key, Object obj) {
        try {
            mMemoryCacheManager.save(key, obj);
        } catch (Exception e) {
        }
    }

    @Override
    public void deleteCacheQuietly(String key) {
        try {
            mMemoryCacheManager.remove(key);
        } catch (Exception e) {
        }
    }

    @Override
    public void release() {
        mMemoryCacheManager = null;
    }
}
