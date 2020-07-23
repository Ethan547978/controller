package com.app.controller.store.local.cache;
import com.app.controller.exception.CacheException;
import com.app.controller.store.local.cache.manager.FileCacheManager;
import com.app.controller.store.local.cache.manager.MemoryCacheManager;

public class BeanCache {
    private MemoryCache mMemoryCache;
    private FileCache mFileCache;

    public BeanCache(FileCacheManager fileCacheManager, MemoryCacheManager httpMemoryCacheManager) {
        mMemoryCache = new MemoryCache(httpMemoryCacheManager);
        mFileCache = new FileCache(fileCacheManager);
    }

    public <T> CacheResult<T> getCache(String key, Class<T> clazz) throws CacheException {
        T result = mMemoryCache.getCache(key, clazz);
        if (result != null) {
            return new CacheResult(result, true);
        } else {
            result = mFileCache.getCache(key, clazz);
            if (result != null) {
                return new CacheResult(result);
            } else {
                return null;
            }
        }
    }

    public <T> CacheResult<T> getMemoryCache(String key, Class<T> clazz) throws CacheException {
        T result = mMemoryCache.getCache(key, clazz);
        if (result != null) {
            return new CacheResult(result, true);
        } else {
            return null;
        }
    }

    public <T> CacheResult<T> getFileCache(String key, Class<T> clazz) throws CacheException {
        T result = mFileCache.getCache(key, clazz);
        if (result != null) {
            return new CacheResult(result);
        } else {
            return null;
        }
    }

    public void putCache(String key, Object obj) throws CacheException {
        mMemoryCache.putCache(key, obj);
        mFileCache.putCache(key, obj);
    }

    public void deleteCache(String key) throws CacheException {
        mMemoryCache.deleteCache(key);
        mFileCache.deleteCache(key);
    }

    public <T> CacheResult<T> getCacheQuietly(String key, Class<T> clazz) {
        T result = mMemoryCache.getCacheQuietly(key, clazz);
        if (result != null) {
            return new CacheResult(result, true);
        } else {
            result = mFileCache.getCacheQuietly(key, clazz);
            if (result != null) {
                return new CacheResult(result);
            } else {
                return null;
            }
        }
    }

    public void putCacheQuietly(String key, Object obj) {
        mMemoryCache.putCacheQuietly(key, obj);
        mFileCache.putCacheQuietly(key, obj);
    }

    public void deleteCacheQuietly(String key) {
        mMemoryCache.deleteCacheQuietly(key);
        mFileCache.deleteCacheQuietly(key);
    }

    public void release() {
        mMemoryCache.release();
        mFileCache.release();
        mMemoryCache = null;
        mFileCache = null;
    }
}
