package com.app.controller.controller;

import com.app.controller.controller.core.BaseControllers;

/**
 * Description : 首页Home Tab的Controller
 * Creator : ZST
 * Data : 2017/8/25.
 */
public class HomeController extends BaseControllers {

    private HomeController() {

    }

    private static class SingletonHolder {
        private static final HomeController INSTANCE = new HomeController();
    }

    public static HomeController getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
