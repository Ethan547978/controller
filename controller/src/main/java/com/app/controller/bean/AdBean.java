package com.app.controller.bean;

/**
 * Description : description
 * Creator : ZST
 * Data : 2017/8/29
 */
public class AdBean {

    private String id;
    private String zbid;
    private int sid;
    private String exturl;
    private String viewid;
    private String lnurl;
    private String type;
    private String imgurl;
    private String videoId;
    private String playUrl;
    private int share_status;//	是否可以分享: 0不能分享;1可以分享
    private String share_title;
    private String share_description;
    private String share_icon;

    public String getShare_description() {
        return share_description;
    }

    public void setShare_description(String share_description) {
        this.share_description = share_description;
    }

    public String getShare_icon() {
        return share_icon;
    }

    public void setShare_icon(String share_icon) {
        this.share_icon = share_icon;
    }

    public String getShare_title() {
        return share_title;
    }

    public void setShare_title(String share_title) {
        this.share_title = share_title;
    }

    public int getShare_status() {
        return share_status;
    }

    public void setShare_status(int share_status) {
        this.share_status = share_status;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLnurl() {
        return lnurl;
    }

    public void setLnurl(String lnurl) {
        this.lnurl = lnurl;
    }

    public String getViewid() {
        return viewid;
    }

    public void setViewid(String viewid) {
        this.viewid = viewid;
    }

    public String getExturl() {
        return exturl;
    }

    public void setExturl(String exturl) {
        this.exturl = exturl;
    }

    public String getZbid() {
        return zbid;
    }

    public void setZbid(String zbid) {
        this.zbid = zbid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
