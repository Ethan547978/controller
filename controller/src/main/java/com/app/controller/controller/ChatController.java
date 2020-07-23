package com.app.controller.controller;

import com.google.gson.Gson;
import com.app.controller.account.AccountManager;
import com.app.controller.bean.ChatStudentInfo;
import com.app.controller.bean.ChatTeacherInfo;
import com.app.controller.bean.ContactInfoBean;
import com.app.controller.controller.core.BaseControllers;
import com.app.controller.controller.core.Controller;
import com.app.controller.controller.core.ControllerRunnable;
import com.app.controller.controller.core.Listener;
import com.app.controller.store.remote.store.HttpChatStore;

import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;

public class ChatController extends BaseControllers {

    private ChatController() {

    }

    private static class SingletonHolder {
        private static final ChatController INSTANCE = new ChatController();
    }

    public static ChatController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //联系人列表
    public Controller getContactList(final int userId, final Listener<List<ContactInfoBean>> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<List<ContactInfoBean>>() {
            @Override
            public List<ContactInfoBean> run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                    paramsMap.put("userId", userId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpChatStore.class).getContactList(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }

    //获取学生个人资料
    public Controller getStudentInfo(final String imUsername, final Listener<ChatStudentInfo> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<ChatStudentInfo>() {
            @Override
            public ChatStudentInfo run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("imUsername", imUsername);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpChatStore.class).getStudentInfo(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }

    //获取教职工个人资料
    public Controller getTeacherInfo(final String imUsername, final Listener<ChatTeacherInfo> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<ChatTeacherInfo>() {
            @Override
            public ChatTeacherInfo run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("imUsername", imUsername);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpChatStore.class).getTeacherInfo(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }

    //获取环信用户信息
    public Controller getUserInfo(final String imUsername, final Listener<ContactInfoBean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<ContactInfoBean>() {
            @Override
            public ContactInfoBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("imUsername", imUsername);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpChatStore.class).getUserInfo(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }

    //环信用户批量信息
    public Controller getImUserList(final List<String> imUsernameList, final Listener<List<ContactInfoBean>> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<List<ContactInfoBean>>() {
            @Override
            public List<ContactInfoBean> run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("imUsernameList", imUsernameList);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpChatStore.class).getImUserList(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }
}
