package com.app.controller.controller;


import com.google.gson.Gson;
import com.app.controller.CommonModule;
import com.app.controller.R;
import com.app.controller.account.Account;
import com.app.controller.account.AccountManager;
import com.app.controller.bean.LoginBean;
import com.app.controller.controller.core.BaseControllers;
import com.app.controller.controller.core.Controller;
import com.app.controller.controller.core.ControllerRunnable;
import com.app.controller.controller.core.Listener;
import com.app.controller.exception.ClientException;
import com.app.controller.store.remote.store.HttpUserStore;

import java.util.HashMap;

import okhttp3.RequestBody;

/**
 * Description : 跟用户信息相关的Controller
 * Creator : ZST
 * Data : 2017/8/25.
 */
public class UserController extends BaseControllers {

    private UserController() {

    }

    private static class SingletonHolder {
        private static final UserController INSTANCE = new UserController();
    }

    public static UserController getInstance() {
        return SingletonHolder.INSTANCE;
    }


    /**
     * 登录
     *
     * @param loginMobile
     * @param code
     * @param password
     * @param listener
     * @return
     */
    public Controller login(final String loginType, final String loginMobile, final String code, final String password, final Listener<LoginBean> listener) {
        final Controller controller = new Controller(Account.newAccount(), listener);
        callStart(controller);
        runToAsyncThreadWithHttp(new Runnable() {
            @Override
            public void run() {
                try {
                    Gson gson = new Gson();
                    HashMap<String, String> paramsMap = new HashMap<>();
                    paramsMap.put("type", loginType);
                    paramsMap.put("mobile", loginMobile);
                    paramsMap.put("code", code);
                    paramsMap.put("password", password);
                    String strEntity = gson.toJson(paramsMap);
                    RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                    LoginBean result = runData(getProtocol(HttpUserStore.class).login(body));

                    Account loginAccount = saveLoginAccount(loginType, loginMobile, password, result);
                    AccountManager.getInstance().saveLastLoginType(loginType);

                    callNext(controller, result);
                    callComplete(controller);
                } catch (ClientException e) {
                    callError(controller, e);
                } catch (Exception e) {
                    callError(controller, new ClientException(CommonModule.getAppContext().getString(R.string.login_fail)));
                }
            }
        });

        return controller;
    }

    private Account saveLoginAccount(String loginType, String loginMobile, String password, LoginBean result) {
        Account newLoginAccount = Account.newAccount();

        newLoginAccount.setUid(result.getUserId(),result.getType());
        newLoginAccount.setUserType(result.getUserId(),result.getType());
        newLoginAccount.setToken(result.getToken());
        newLoginAccount.setNickName(result.getName());
        newLoginAccount.setIcon(result.getLogo());
        newLoginAccount.setMobile(result.getMobile());
        newLoginAccount.setIMUserName(result.getImUsername());
        newLoginAccount.setIMPassword(result.getImPassword());
        newLoginAccount.setTeacher(result.getTeacher());
        newLoginAccount.setSchool(result.getSchool());
        newLoginAccount.setStudentsInfos(result.getStudents());
        newLoginAccount.setClassesInfo(result.getClasses());
        if (result.getType() == 1) {
            if (result.getTeacher() != null){
                newLoginAccount.setIcon(result.getTeacher().getLogo());
                newLoginAccount.setSex(result.getTeacher().getSex());
            }
        } else if (result.getType() == 2) {
            if (result.getStudents() != null && !result.getStudents().isEmpty()) {
                newLoginAccount.setIcon(result.getStudents().get(0).getLogo());
                newLoginAccount.setSex(result.getStudents().get(0).getSex());
            }
        }

        if (loginType.equals("1")) {//密码登录时，保存密码
            newLoginAccount.setPassword(password);
        }

        AccountManager.getInstance().saveLoginAccount(newLoginAccount);
        newLoginAccount.updateToLoginAccount();

        AccountManager.getInstance().saveLastLoginMobile(loginMobile);

        return newLoginAccount;
    }

    public Controller register(final String mobile,final String code,final String password,final Listener<Boolean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Boolean>() {
            @Override
            public Boolean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("mobile", mobile);
                paramsMap.put("code", code);
                paramsMap.put("password", password);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpUserStore.class).register(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }

    /**
     * 退出登录
     */
    public Controller logout(final Listener<Boolean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Boolean>() {
            @Override
            public Boolean run(Controller controller) {
                return runData(getProtocol(HttpUserStore.class).logout(AccountManager.getInstance().getLoginAccount().getToken()));
            }
        });
    }

    public Controller sendCode(final int type,final String mobile,final Listener<Boolean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Boolean>() {
            @Override
            public Boolean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("type", type);
                paramsMap.put("mobile", mobile);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpUserStore.class).sendCode(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }

    public Controller changePassword(final String mobile,final String code,final String password,final Listener<Boolean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Boolean>() {
            @Override
            public Boolean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("mobile", mobile);
                paramsMap.put("code", code);
                paramsMap.put("password", password);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpUserStore.class).changePassword(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }

    public Controller changePassword2(final String oldPassword,final String newPassword,final Listener<Boolean> listener) {
        return runCommandController(AccountManager.getInstance().getLoginAccount(), listener, new ControllerRunnable<Boolean>() {
            @Override
            public Boolean run(Controller controller) {
                Gson gson = new Gson();
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put("oldPassword", oldPassword);
                paramsMap.put("newPassword", newPassword);
                String strEntity = gson.toJson(paramsMap);
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), strEntity);
                return runData(getProtocol(HttpUserStore.class).changePassword2(AccountManager.getInstance().getLoginAccount().getToken(),body));
            }
        });
    }
}
