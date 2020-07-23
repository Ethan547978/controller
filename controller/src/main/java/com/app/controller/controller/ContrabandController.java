package com.app.controller.controller;

import com.google.gson.Gson;
import com.app.controller.account.AccountManager;
import com.app.controller.bean.ContrabandBean;
import com.app.controller.bean.ContrabandListBean;
import com.app.controller.bean.ContrabandVisitorBean;
import com.app.controller.bean.ContrabandVisitorListBean;
import com.app.controller.controller.core.BaseControllers;
import com.app.controller.controller.core.Controller;
import com.app.controller.controller.core.ControllerCacheParams;
import com.app.controller.controller.core.ControllerRunnable;
import com.app.controller.controller.core.Listener;
import com.app.controller.store.remote.store.HttpContrabandStore;
import com.app.library.utils.StringUtils;

import java.util.HashMap;

import okhttp3.RequestBody;

public class ContrabandController extends BaseControllers {
    private ContrabandController() {

    }

    private static class SingletonHolder {
        private static final ContrabandController INSTANCE = new ContrabandController();
    }

    public static ContrabandController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Controller findStudents(final int status, final String createTimeStart,final String createTimeEnd, final int pageNum, final int pageSize, final Listener<ContrabandBean> listener) {
        return runDataController(new ControllerCacheParams(false, false, "findStudents"), listener, new ControllerRunnable<ContrabandBean>() {
            @Override
            public ContrabandBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("status", status);
                if (!StringUtils.isEmpty(createTimeStart)){
                    paramsMap.put("createTimeStart", createTimeStart);
                }
                if (!StringUtils.isEmpty(createTimeEnd)){
                    paramsMap.put("createTimeEnd", createTimeEnd);
                }

                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpContrabandStore.class).findStudents(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    public Controller findVisitors(final int status, final String createTimeStart,final String createTimeEnd, final int pageNum, final int pageSize, final Listener<ContrabandVisitorBean> listener) {
        return runDataController(new ControllerCacheParams(false, false, "findVisitors"), listener, new ControllerRunnable<ContrabandVisitorBean>() {
            @Override
            public ContrabandVisitorBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("status", status);
                if (!StringUtils.isEmpty(createTimeStart)){
                    paramsMap.put("createTimeStart", createTimeStart);
                }
                if (!StringUtils.isEmpty(createTimeEnd)){
                    paramsMap.put("createTimeEnd", createTimeEnd);
                }

                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpContrabandStore.class).findVisitors(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    public Controller dealStudent(final int id, final String images,final String content, final String hasContraband, final Listener<Object> listener) {
        return runDataController(new ControllerCacheParams(false, false, "dealStudent"), listener, new ControllerRunnable<Object>() {
            @Override
            public Object run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("id", id);
                if (!StringUtils.isEmpty(images)){
                    paramsMap.put("images", images);
                }
                paramsMap.put("content", content);
                paramsMap.put("hasContraband", hasContraband);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpContrabandStore.class).dealStudent(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    public Controller dealVisitor(final int id, final String images,final String content, final String hasContraband, final Listener<Object> listener) {
        return runDataController(new ControllerCacheParams(false, false, "dealVisitor"), listener, new ControllerRunnable<Object>() {
            @Override
            public Object run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("id", id);
                if (!StringUtils.isEmpty(images)){
                    paramsMap.put("images", images);
                }
                paramsMap.put("content", content);
                paramsMap.put("hasContraband", hasContraband);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpContrabandStore.class).dealVisitor(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    public Controller getContrabandStudent(final int contrabandId, final Listener<ContrabandListBean> listener) {
        return runDataController(new ControllerCacheParams(false, false, "dealVisitor"), listener, new ControllerRunnable<ContrabandListBean>() {
            @Override
            public ContrabandListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("contrabandId", contrabandId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpContrabandStore.class).getContrabandStudent(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
    public Controller getContrabandVisitor(final int contrabandId, final Listener<ContrabandVisitorListBean> listener) {
        return runDataController(new ControllerCacheParams(false, false, "dealVisitor"), listener, new ControllerRunnable<ContrabandVisitorListBean>() {
            @Override
            public ContrabandVisitorListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("contrabandId", contrabandId);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpContrabandStore.class).getContrabandVisitor(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }
}
