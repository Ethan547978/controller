package com.app.controller.controller;

import com.google.gson.Gson;
import com.app.controller.account.AccountManager;
import com.app.controller.bean.GetVisitorListBean;
import com.app.controller.controller.core.BaseControllers;
import com.app.controller.controller.core.Controller;
import com.app.controller.controller.core.ControllerCacheParams;
import com.app.controller.controller.core.ControllerRunnable;
import com.app.controller.controller.core.Listener;
import com.app.controller.store.remote.store.HttpSchoolStore;
import com.app.library.utils.StringUtils;

import java.util.HashMap;

import okhttp3.RequestBody;

public class StudentController extends BaseControllers {
    private StudentController() {

    }

    private static class SingletonHolder {
        private static final StudentController INSTANCE = new StudentController();
    }

    public static StudentController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     *
     *
     * @param status
     * @param pageNum
     * @param pageSize
     * @param listener
     * @return
     */
    public Controller getVisitorList(final int status, final int pageNum, final int pageSize, final Listener<GetVisitorListBean> listener) {

        return runDataController(new ControllerCacheParams(false, false, "getVisitorList"), listener, new ControllerRunnable<GetVisitorListBean>() {
            @Override
            public GetVisitorListBean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("status", status);
                paramsMap.put("pageNum", pageNum);
                paramsMap.put("pageSize", pageSize);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpSchoolStore.class).getVisitorList(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * @return
     */
    public Controller saveVisitor(final String name, final String idNo, final String mobile,
                                  final String picture, final String visitDate, final String visitTimeStart,
                                  final String visitTimeEnd, final int visitReason, final String visitMobile,
                                  final String remark, final String together,
                                  final Listener<Integer> listener) {

        return runDataController(new ControllerCacheParams(false, false, "saveVisitor"), listener, new ControllerRunnable<Integer>() {
            @Override
            public Integer run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                if (!StringUtils.isEmpty(picture)){
                    paramsMap.put("picture", picture);
                }
                if (!StringUtils.isEmpty(remark)){
                    paramsMap.put("remark", remark);
                }
                paramsMap.put("name", name);
                paramsMap.put("idNo", idNo);
                paramsMap.put("mobile", mobile);
                paramsMap.put("visitDate", visitDate);
                paramsMap.put("visitTimeStart", visitTimeStart);
                paramsMap.put("visitTimeEnd", visitTimeEnd);
                paramsMap.put("visitReason", visitReason);
                paramsMap.put("visitMobile", visitMobile);
                paramsMap.put("together", together);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpSchoolStore.class).saveVisitor(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

    /**
     * @return
     */
    public Controller editVisitorState(final int id, final int status,
                                  final Listener listener) {

        return runDataController(new ControllerCacheParams(false, false, "editVisitorState"), listener, new ControllerRunnable<Object>() {
            @Override
            public Object run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();

                paramsMap.put("id", id);
                paramsMap.put("status", status);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpSchoolStore.class).editVisitorState(AccountManager.getInstance().getLoginAccount().getToken(), body));
            }
        });
    }

}
