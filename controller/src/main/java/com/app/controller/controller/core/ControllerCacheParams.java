package com.app.controller.controller.core;

public class ControllerCacheParams {

    /**
     * 是否访问缓存
     */
    private boolean isNeedCache;
    private boolean isSaveCache;
    private String cacheKey;
    private Object[] cacheKeys;

    /**
     * @param isNeedCache 是否需要获取缓存，
     * @param isSaveCache 是否需要 保存缓存
     * @param cacheKey    缓存名
     * @param cacheKeys   缓存参数
     */
    public ControllerCacheParams(boolean isNeedCache, boolean isSaveCache, String cacheKey, Object... cacheKeys) {
        this.isNeedCache = isNeedCache;
        this.cacheKey = cacheKey;
        this.isSaveCache = isSaveCache;
        this.cacheKeys = cacheKeys;
    }

    public boolean isNeedCache() {
        return isNeedCache;
    }

    public boolean isSaveCache() {
        return isSaveCache;
    }

    public Object[] getCacheKeys() {
        if (cacheKeys == null) {
            return new Object[0];
        }
        
        return cacheKeys;
    }

    public String getCacheKey() {
        return cacheKey;
    }
}
