package com.app.controller.controller.core;

import com.app.controller.exception.ClientException;

public class Listener<T> {

    /**
     * 操作任务开始
     *
     * @param controller
     */
    public void onStart(Controller controller) {

    }

    /**
     * 获取到本地缓存结果
     *
     * @param controller
     * @param result
     */
    public void onCacheComplete(Controller controller, T result) {

    }

    /**
     * 获取本地缓存结果失败
     *
     * @param controller
     */
    public void onCacheFail(Controller controller) {

    }

    /**
     * 获取到结果
     *
     * @param controller
     * @param result
     */
    public void onNext(Controller controller, T result) {

    }

    /**
     * 操作任务完成
     *
     * @param controller
     */
    public void onComplete(Controller controller) {

    }

    /**
     * 操作任务发生异常
     *
     * @param controller
     * @param error
     */
    public void onError(Controller controller, ClientException error) {

    }
}
