package com.app.controller.thread;


import com.app.library.utils.LogUtils;


public class ReceiveGiftScheduleThread extends Thread {

    protected volatile boolean exit = false;

    /**
     * 改变标记位，让线程执行完毕
     */
    public void terminateScheduleThread() {
        exit = true;
    }

    /**
     * 改变标记位，让线程执行完毕
     */
    public void terminateScheduleThread(Object yourLock) {
        exit = true;
        if (this.getState()== State.BLOCKED) {
            synchronized (yourLock) {
                LogUtils.d("enterRoom","------>线程被阻塞，准备唤醒");
                yourLock.notify();
            }
        }
    }

    /**
     * 改变标记位，让线程可循环
     */
    public void resetScheduleThread() {
        exit = false;
        if (this.getState()== State.TERMINATED) {
            LogUtils.d("enterRoom","------>线程已结束，准备启动");
            this.start();
        }
    }
}
