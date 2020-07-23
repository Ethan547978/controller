package com.app.controller.store.local.cache.manager;


import com.app.controller.store.local.cache.quitnowCache.QNCache;
import com.app.controller.store.local.cache.quitnowCache.QNCacheBuilder;

/**
 * Description : 内存缓存
 * Creator : ZST
 * Data : 2017/8/25.
 */
public class MemoryCacheManager {

    private MemoryCacheManager() {
        mQNCache = new QNCacheBuilder().setCaseSensitiveKeys(false).setAutoReleaseInSeconds(300).createQNCache();
    }

    private static class SingletonHolder {
        public static final MemoryCacheManager INSTANCE = new MemoryCacheManager();
    }

    public static MemoryCacheManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private QNCache mQNCache;

    public Object get(String key) {
        return mQNCache.get(key);
    }

    public void save(String key, Object object) {
        mQNCache.set(key, object);
    }

    public void save(String key, Object object, long keepAliveInMillis) {
        mQNCache.set(key, object, keepAliveInMillis);
    }

    public void remove(String key) {
        mQNCache.remove(key);
    }

    public void removeAll() {
        mQNCache.clear();
    }

    public boolean contains(String key) {
        return mQNCache.contains(key);
    }

    public boolean isEmpty() {
        return mQNCache.isEmpty();
    }

    public int size() {
        return mQNCache.size();
    }
}
