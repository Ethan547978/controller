package com.app.controller.controller;

import com.google.gson.Gson;
import com.app.controller.account.AccountManager;
import com.app.controller.bean.NoticeDetailBean;
import com.app.controller.bean.NoticeListBean;
import com.app.controller.controller.core.BaseControllers;
import com.app.controller.controller.core.Controller;
import com.app.controller.controller.core.ControllerCacheParams;
import com.app.controller.controller.core.ControllerRunnable;
import com.app.controller.controller.core.Listener;
import com.app.controller.store.remote.store.HttpNoticeStore;

import java.util.HashMap;

import okhttp3.RequestBody;

public class NoticeController extends BaseControllers {
    private NoticeController() {
    }

    private static class SingletonHolder {
        private static final NoticeController INSTANCE = new NoticeController();
    }

    public static NoticeController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Controller getNoticeList(final int noticeType,final int isRead, final int pageNum, final int pageSize, final Listener<NoticeListBean> listener) {

        return runDataController(new ControllerCacheParams(false, false, "getNoticeList"), listener, new ControllerRunnable<NoticeListBean>() {
            @Override
            public NoticeListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("noticeType", noticeType);
                paramsMap.put("isRead", isRead);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpNoticeStore.class).getNoticeList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller getNoticeDetail(final int id, final Listener<NoticeDetailBean> listener) {

        return runDataController(new ControllerCacheParams(false, false, "getNoticeList"), listener, new ControllerRunnable<NoticeDetailBean>() {
            @Override
            public NoticeDetailBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("id", id);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpNoticeStore.class).getNoticeDetail(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
}
