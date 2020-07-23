package com.app.controller.bean;

/**
 * Created by Jackie on 11,九月,2017
 */

public class RegisterBean {

    private String accessToken;
    private String socketToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSocketToken() {
        return socketToken;
    }

    public void setSocketToken(String socketToken) {
        this.socketToken = socketToken;
    }

    @Override
    public String toString() {
        return "RegisterBean{" +
                "accessToken='" + accessToken + '\'' +
                ", socketToken='" + socketToken + '\'' +
                '}';
    }
}
