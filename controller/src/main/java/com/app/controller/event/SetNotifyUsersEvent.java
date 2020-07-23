package com.app.controller.event;

public class SetNotifyUsersEvent {

    private boolean isNotify;
    private String userName;

    public SetNotifyUsersEvent(boolean isNotify, String userName) {
        this.isNotify = isNotify;
        this.userName = userName;
    }

    public boolean isNotify() {
        return isNotify;
    }

    public void setIsNotify(boolean isNotify) {
        this.isNotify = isNotify;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
