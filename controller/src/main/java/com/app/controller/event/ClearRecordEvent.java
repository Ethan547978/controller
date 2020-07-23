package com.app.controller.event;

public class ClearRecordEvent {

    private String conversationId;
    public ClearRecordEvent(String conversationId){
         this.conversationId = conversationId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
}
