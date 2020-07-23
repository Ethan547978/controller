package com.app.controller.event;

public class SetTopConversationEvent {

    private boolean isTop;
    private String userName;

    public SetTopConversationEvent(boolean isTop, String userName) {
        this.isTop = isTop;
        this.userName = userName;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
