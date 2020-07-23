package com.app.controller.bean;


import java.io.Serializable;

public class GenCredentialBean implements Serializable {
    private long expiration;//凭证过期时间
    private String accessKeyId;//STS临时账户
    private String accessKeySecret;//STS临时账户秘钥
    private String securityToken;//STS临时令牌
    private String bucketDomain;
    private String endPoint;
    private String bucket;

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getAccessKeyToken() {
        return securityToken;
    }

    public void setAccessKeyToken(String accessKeyToken) {
        this.securityToken = accessKeyToken;
    }

    public String getBucketDomain() {
        return bucketDomain;
    }

    public void setBucketDomain(String bucketDomain) {
        this.bucketDomain = bucketDomain;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}
