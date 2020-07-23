package com.app.controller.thread;


import com.app.library.utils.ThreadUtil;


public abstract class MyRuningListener implements ThreadUtil.RuningListener{

	@Override
	public void befor() {

	}

	@Override
	public abstract void run();

}
