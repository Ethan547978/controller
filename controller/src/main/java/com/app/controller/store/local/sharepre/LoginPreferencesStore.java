package com.app.controller.store.local.sharepre;


import com.app.controller.account.Account;
import com.app.controller.store.local.sharepre.manager.SharePreferencesManager;

/**
 * Description : description
 * Creator : ZST
 * Data : 2017/9/1
 */
public class LoginPreferencesStore {

    private LoginPreferencesStore() {

    }

    /**
     * 是否自动登录
     */
    public static boolean getIsAutoLogin(Account account) {
        return account.getPreferencesStoreManager().getBooleanCache(SharePreferencesManager.COMMON_DBNAME, "is_auto_login");
    }

    public static void saveIsAutoLogin(Account account, boolean isAutoLogin) {
        account.getPreferencesStoreManager().saveBooleanCache(isAutoLogin, SharePreferencesManager.COMMON_DBNAME, "is_auto_login");
    }

    public static boolean getIsReadUserAgreement(Account account) {
        return account.getPreferencesStoreManager().getBooleanCache(SharePreferencesManager.COMMON_DBNAME, "is_read_user_agreement");
    }

    public static void saveIsReadUserAgreement(Account account, boolean isAutoLogin) {
        account.getPreferencesStoreManager().saveBooleanCache(isAutoLogin, SharePreferencesManager.COMMON_DBNAME, "is_read_user_agreement");
    }

}
