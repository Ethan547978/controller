package com.app.controller.store.local.cache;

public class CacheResult<T> {

    /**
     * 结果
     */
    public T result;

    /**
     * 是否是内存缓存
     */
    public boolean sourceMemory;

    public CacheResult(T result) {
        this.result = result;
    }

    public CacheResult(T result, boolean sourceMemory) {
        this.result = result;
        this.sourceMemory = sourceMemory;
    }
}
