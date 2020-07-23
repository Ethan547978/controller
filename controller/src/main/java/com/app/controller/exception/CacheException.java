package com.app.controller.exception;


/**
 * Creator : ZST
 * Data : 2017/8/25.
 */
public class CacheException extends ClientException {

    public CacheException() {
        super();
    }

    public CacheException(int code) {
        super(code);
    }

    public CacheException(Exception ex) {
        super(ex);
    }

    public CacheException(String detail) {
        super(detail);
    }
}
