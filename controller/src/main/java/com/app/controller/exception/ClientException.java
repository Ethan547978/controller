package com.app.controller.exception;


/**
 * Creator : ZST
 * Data : 2017/8/25.
 */
public class ClientException extends RuntimeException {

    private Throwable mException;
    private String mDetail;
    private int mCode;

    public ClientException() {
    }

    public ClientException(int code, String detail) {
        super(detail);
        setCode(code);
        setDetail(detail);
    }

    public ClientException(int code) {
        setCode(code);
    }

    public ClientException(Throwable ex) {
        setException(ex);
    }

    public ClientException(String detail) {
        super(detail);
        setDetail(detail);
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        this.mCode = code;
    }

    public Throwable getException() {
        return mException;
    }

    public void setException(Throwable exception) {
        this.mException = exception;
    }

    public String getDetail() {
        return mDetail;
    }

    public void setDetail(String detail) {
        this.mDetail = detail;
    }
}
