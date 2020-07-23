package com.app.controller.store.local.sharepre.manager;

import com.app.controller.account.Account;
import com.app.controller.utils.GsonUtils;
import com.app.controller.CommonModule;
/**
 * Description : SharedPreferences
 */
public class SharePreferencesManager {
    //假如有大模块或者需要分类保存的可以增加db,目前基本使用commonDB
    public static final String COMMON_DBNAME = "common";//
    public static final String HOST_SETTING = "host";// ******不可乱加
    public static final String LAST_LOGINACCOUNT = "LastLoginAccount";// ******不可乱加
    public static final String LOGIN_ACCOUNT = "LoginAccount";// ******不可乱加


    private Account mAccount;

    public SharePreferencesManager(Account account) {
        mAccount = account;
    }

    /**
     * 从指定DB获取数据 区分账号
     */
    public synchronized <T> T getCacheByAccount(Class<T> clazz, String dbname, String key) {
        return GsonUtils.getInstance().parseIfNull(clazz, new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid()).getString(key));
    }

    public synchronized long getLongCacheByAccount(String dbname, String key) {
        return new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid()).getLong(key);
    }

    public synchronized int getIntCacheByAccount(String dbname, String key) {
        return new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid()).getInt(key);
    }

    public synchronized float getFloatCacheByAccount(String dbname, String key) {
        return new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid()).getFloat(key);
    }

    public synchronized String getStringCacheByAccount(String dbname, String key) {
        return new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid()).getString(key);
    }

    public synchronized boolean getBooleanCacheByAccount(String dbname, String key) {
        return new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid()).getBoolean(key);
    }

    /**
     * 从指定DB获取数据 不区分账号（不区分账号的情况：如-是否已经提示过有新版本可以更新、是否已经显示过新手引导页、定位位置等等；）
     */
    public synchronized <T> T getCache(Class<T> clazz, String dbname, String key) {
        return GsonUtils.getInstance().parseIfNull(clazz, new LocalPreferencesHelper(CommonModule.getAppContext(), dbname).getString(key));
    }

    public synchronized long getLongCache(String dbname, String key) {
        return new LocalPreferencesHelper(CommonModule.getAppContext(), dbname).getLong(key);
    }

    public synchronized int getIntCache(String dbname, String key) {
        return new LocalPreferencesHelper(CommonModule.getAppContext(), dbname).getInt(key);
    }

    public synchronized float getFloatCache(String dbname, String key) {
        return new LocalPreferencesHelper(CommonModule.getAppContext(), dbname).getFloat(key);
    }

    public synchronized String getStringCache(String dbname, String key) {
        return new LocalPreferencesHelper(CommonModule.getAppContext(), dbname).getString(key);
    }

    public synchronized boolean getBooleanCache(String dbname, String key) {
        return new LocalPreferencesHelper(CommonModule.getAppContext(), dbname).getBoolean(key);
    }

    /**
     * 保存数据到指定DB 区分账号
     */
    public synchronized <T> void saveCacheByAccount(T result, String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid());
        helper.saveOrUpdate(key, GsonUtils.getInstance().parseIfNull(result));
    }

    public synchronized void saveLongCacheByAccount(long result, String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid());
        helper.saveOrUpdate(key, result);
    }

    public synchronized void saveIntCacheByAccount(int result, String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid());
        helper.saveOrUpdate(key, result);
    }

    public synchronized void saveFloatCacheByAccount(float result, String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid());
        helper.saveOrUpdate(key, result);
    }

    public synchronized void saveBooleanCacheByAccount(boolean result, String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid());
        helper.saveOrUpdate(key, result);
    }

    public synchronized void saveStringCacheByAccount(String result, String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid());
        helper.saveOrUpdate(key, result);
    }

    /**
     * 保存数据到指定DB  不区分账号
     */
    public synchronized <T> void saveCache(T result, String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname);
        helper.saveOrUpdate(key, GsonUtils.getInstance().parseIfNull(result));
    }

    public synchronized void saveLongCache(long result, String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname);
        helper.saveOrUpdate(key, result);
    }

    public synchronized void saveIntCache(int result, String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname);
        helper.saveOrUpdate(key, result);
    }

    public synchronized void saveFloatCache(float result, String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname);
        helper.saveOrUpdate(key, result);
    }

    public synchronized void saveBooleanCache(boolean result, String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname);
        helper.saveOrUpdate(key, result);
    }

    public synchronized void saveStringCache(String result, String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname);
        helper.saveOrUpdate(key, result);
    }

    /**
     * 从指定DB内清除指定数据 区分账号
     */
    public synchronized <T> void clearCacheByAccount(String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid());
        helper.del(key);
    }

    /**
     * 从指定DB内清除指定数据 不区分账号
     */
    public synchronized <T> void clearCache(String dbname, String key) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname);
        helper.del(key);
    }

    /**
     * 从指定DB内清除所有数据 区分账号
     */
    public synchronized <T> void clearCacheByAccount(String dbname) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname + mAccount.getUid());
        helper.clear();
    }

    /**
     * 从指定DB内清除所有数据  不区分账号
     */
    public synchronized <T> void clearCache(String dbname) {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), dbname);
        helper.clear();
    }

    public synchronized void commmitToDisk() {
        LocalPreferencesHelper helper = new LocalPreferencesHelper(CommonModule.getAppContext(), COMMON_DBNAME);
        helper.commmitToDisk();
        helper = new LocalPreferencesHelper(CommonModule.getAppContext(), HOST_SETTING);
        helper.commmitToDisk();
        helper = new LocalPreferencesHelper(CommonModule.getAppContext(), LOGIN_ACCOUNT);
        helper.commmitToDisk();
        helper = new LocalPreferencesHelper(CommonModule.getAppContext(), LAST_LOGINACCOUNT);
        helper.commmitToDisk();
    }

}
