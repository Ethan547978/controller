package com.app.controller.bean;


public class BootBean {

    private int second;

    private int type;

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAndroid_img_url() {
        return android_img_url;
    }

    public void setAndroid_img_url(String android_img_url) {
        this.android_img_url = android_img_url;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    private String android_img_url;

    private String video_url;

    public boolean isVideo(){
        return type == 2;
    }

    @Override
    public String toString() {
        return "BootBean{" +
                "second=" + second +
                ", type=" + type +
                ", android_img_url='" + android_img_url + '\'' +
                ", video_url='" + video_url + '\'' +
                '}';
    }
}
