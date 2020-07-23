package com.app.controller.exception;

/**
 * Creator : ZST
 * Data : 2017/8/25.
 */
public class HttpException extends ClientException {

    public HttpException() {
        super();
    }

    public HttpException(int code) {
        super(code);
    }

    public HttpException(Exception ex) {
        super(ex);
    }

    public HttpException(String detail) {
        super(detail);
    }

    public HttpException(int code, String detail) {
        super(code, detail);
    }
}
