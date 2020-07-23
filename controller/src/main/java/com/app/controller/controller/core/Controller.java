package com.app.controller.controller.core;


import com.app.controller.account.Account;

public class Controller {
    private Account mAccount;//帐号
    private Listener<?> mListener;//Listener
    private ProgressListener mProgressListener;
    private final String mTag;

    private boolean isCancel;
    private Object flag;

    public Controller(Account account, Listener<?> listener) {
        this.mAccount = account;
        this.mListener = listener;
        this.mTag = String.valueOf(System.nanoTime());
    }


    public Controller(Account account, Listener<?> listener, ProgressListener progressListener) {
        this.mAccount = account;
        this.mListener = listener;
        this.mTag = String.valueOf(System.nanoTime());
        this.mProgressListener = progressListener;
    }

    /**
     * 获取Listener
     *
     * @return
     */
    public Listener<?> getListener() {
        return mListener;
    }

    public void setListener(Listener<?> listener) {
        mListener = listener;
    }

    /**
     * 清除Listener
     */
    public void clearListener() {
        if (mListener != null) {
            mListener = null;
        }

        if (mProgressListener != null) {
            mProgressListener=null;
        }
    }

    /**
     * 取消
     */
    public void cancelController() {
        isCancel = true;
        clearListener();
//        HttpProtocolFactory.getInstance().cancelRequest(mTag);
    }

    /**
     * 是否已取消
     *
     * @return
     */
    public boolean isCancel() {
        return isCancel;
    }

    /**
     * 账号
     *
     * @return
     */
    public Account getAccount() {
        return mAccount;
    }

    /**
     * tag
     *
     * @return
     */
    public String getTag() {
        return mTag;
    }

    public void setFlag(Object flag) {
        this.flag = flag;
    }

    public Object getFlag() {
        return flag;
    }
}
