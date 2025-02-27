package com.app.controller.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.app.controller.exception.ClientException;

import java.io.Reader;
import java.lang.reflect.Type;

public class GsonUtils {
    private Gson mGson;

    private GsonUtils() {
        mGson = new GsonBuilder()
                .serializeNulls()
                .create();
    }

    private static class SingletonHolder {
        public static final GsonUtils INSTANCE = new GsonUtils();
    }

    public static GsonUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Gson getGson() {
        return mGson;
    }

    public <T> T parseIfNull(Type typeOfT, String json) {
        try {
            return mGson.fromJson(json, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T parse(Type typeOfT, String json) throws ClientException {
        try {
            return mGson.fromJson(json, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClientException(e);
        }
    }

    public <T> T parseIfNull(Type typeOfT, Reader json) {
        try {
            return mGson.fromJson(json, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T parse(Type typeOfT, Reader json) throws ClientException {
        try {
            return mGson.fromJson(json, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClientException(e);
        }
    }

    public <T> T parseIfNull(Class<T> clazz, String json) {
        try {
            return mGson.fromJson(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T parse(Class<T> clazz, String json) throws ClientException {
        try {
            return mGson.fromJson(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClientException(e);
        }
    }

    public <T> String parseIfNull(T object) {
        try {
            return mGson.toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> String parse(T object) throws ClientException {
        try {
            return mGson.toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClientException(e);
        }
    }
}
