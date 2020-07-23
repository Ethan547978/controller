package com.app.controller.controller.core;

import com.app.controller.exception.ClientException;

public abstract class ControllerRunnable<T>{

    /**
     * run之前运行
     *
     * @param controller
     */
    public void onPreRun(Controller controller){
    }

    /**
     * 返回remote访问的结果
     *
     * @param controller
     * @return
     */
    public abstract T run(Controller controller);

    /**
     * run之后运行
     *
     * @param controller
     */
    public void onPostRun(Controller controller, T result){
    }

    /**
     * cacheComplete之前运行
     */
    public void onPreCacheComplete(Controller controller, T cache){

    }

    /**
     * callError之前运行
     *
     * @param controller
     * @param exception
     */
    public void onPreError(Controller controller, ClientException exception){

    }
}
