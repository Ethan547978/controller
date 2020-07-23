package com.app.controller.store.local.sharepre.manager;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Description : 基于SharedPreferences的本地缓存工具类
 * Creator : ZST
 * Data : 2017/8/31.
 */
public class LocalPreferencesHelper {

    private SharedPreferences mSharedPreferences;

    public LocalPreferencesHelper(Context context, String dbName) {
        mSharedPreferences = context.getSharedPreferences(dbName,
                Context.MODE_PRIVATE);
    }

    public void saveOrUpdate(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    public void saveOrUpdate(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public void saveOrUpdate(String key, float value) {
        mSharedPreferences.edit().putFloat(key, value).apply();
    }

    public void saveOrUpdate(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public void saveOrUpdate(String key, long value) {
        mSharedPreferences.edit().putLong(key, value).apply();
    }

    public void del(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }

    public float getFloat(String key) {
        return mSharedPreferences.getFloat(key, -1);
    }

    public String getString(String key) {
        return mSharedPreferences.getString(key, "");
    }

    public String getString(String key, String defaultValue){
        return mSharedPreferences.getString(key,defaultValue);
    }

    public boolean getBoolean(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    public int getInt(String key) {
        return getInt(key, -1);
    }

    public int getInt(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public long getLong(String key) {
        return mSharedPreferences.getLong(key, -1);
    }

    public long getLong(String key, long defaultValue) {
        return mSharedPreferences.getLong(key, defaultValue);
    }

    public Map<String, ?> getAll() {
        return mSharedPreferences.getAll();
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }

    public void commmitToDisk() {
        mSharedPreferences.edit().commit();
    }
}