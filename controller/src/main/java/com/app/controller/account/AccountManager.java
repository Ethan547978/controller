package com.app.controller.account;
import com.app.controller.CommonModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.app.controller.store.local.sharepre.manager.LocalPreferencesHelper;
import com.app.controller.store.local.sharepre.manager.SharePreferencesManager;

/**
 * Description : 账号manager
 * Creator : ZST
 * Data : 2017/8/25.
 */
public class AccountManager {

    private static class SingletonHolder {
        public static final AccountManager INSTANCE = new AccountManager();
    }

    public static AccountManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private AccountManager() {
        mLocalPreferencesHelper = new LocalPreferencesHelper(CommonModule.getAppContext(), SharePreferencesManager.LOGIN_ACCOUNT);
    }

    private Gson mGson;
    private volatile Account mLoginAccount;
    private LocalPreferencesHelper mLocalPreferencesHelper;

    /**
     * 获取当前登录账号
     */
    public Account getLoginAccount() {
        if (mLoginAccount != null) {
            return mLoginAccount;
        }

        return getLoginAccountForCache();
    }

    /**
     * 获取当前登录账号
     */
    public Account getLoginAccountForCache() {
        long uid = mLocalPreferencesHelper.getLong("user-key");
        Account account = null;

        if (uid > 0) {
            try {
                String json = mLocalPreferencesHelper.getString("user-data");
                account = getGson().fromJson(json, new TypeToken<Account>() {
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (account == null) {
            mLoginAccount = null;
            return Account.newAccount();
        } else {
            mLoginAccount = account;
            return mLoginAccount;
        }
    }

    /**
     * 保存当前账号
     */
    public void saveLoginAccount(Account account) {
        if (account == null) {
            return;
        }
        mLoginAccount = account;
        mLocalPreferencesHelper.saveOrUpdate("user-key", account.getUid());
        mLocalPreferencesHelper.saveOrUpdate("user-data", getGson().toJson(account));
    }

    /**
     * 清除当前登录账号信息
     */
    public void clearLoginAccount() {
        mLoginAccount = null;
        mLocalPreferencesHelper.clear();
        commmitToDisk();
        getLoginAccountForCache();
    }

    public boolean isLogin() {
        Account account = getLoginAccount();
        return account != null;
    }

    /**
     * 获取最后一次登录的类型
     */
    public String getLastLoginType() {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(CommonModule.getAppContext(), SharePreferencesManager.LAST_LOGINACCOUNT);
        return localPreferencesHelper.getString("LastLoginType");
    }

    /**
     * 保存最后一次登录的类型
     */
    public void saveLastLoginType(String loginType) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(CommonModule.getAppContext(), SharePreferencesManager.LAST_LOGINACCOUNT);
        localPreferencesHelper.saveOrUpdate("LastLoginType", loginType);
    }

    /**
     * 获取最后一次登录的手机号
     */
    public String getLastLoginMobile() {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(CommonModule.getAppContext(), SharePreferencesManager.LAST_LOGINACCOUNT);
        return localPreferencesHelper.getString("LastLoginMobile");
    }

    /**
     * 保存最后一次登录的手机号
     */
    public void saveLastLoginMobile(String username) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(CommonModule.getAppContext(), SharePreferencesManager.LAST_LOGINACCOUNT);
        localPreferencesHelper.saveOrUpdate("LastLoginMobile", username);
    }

    /**
     * 清除最后一次登录的手机号
     */
    public void clearLastLoginMobile() {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(CommonModule.getAppContext(), SharePreferencesManager.LAST_LOGINACCOUNT);
        localPreferencesHelper.del("LastLoginMobile");
    }

    void commmitToDisk() {
        mLocalPreferencesHelper.commmitToDisk();
    }

    private Gson getGson() {
        if (mGson != null) {
            return mGson;
        }

        return mGson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation() // 只序列化Expose字段
                .serializeNulls().setPrettyPrinting() // 对json结果格式化.
                .create();
    }
}
