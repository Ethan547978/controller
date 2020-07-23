package com.app.controller.store.local.sharepre;


import com.app.controller.account.Account;
import com.app.controller.bean.ContactInfoBean;
import com.app.controller.store.local.sharepre.manager.SharePreferencesManager;

import java.util.List;
import java.util.Map;

/**
 * Description : description
 * Creator : ZST
 * Data : 2017/9/1
 */
public class CommonPreferencesStore {

    private CommonPreferencesStore() {

    }

    /**
     * 获取保存的置顶会话用户
     * @return
     */
    public static List getTopConversation(Account account) {
        return account.getPreferencesStoreManager().getCacheByAccount(List.class, SharePreferencesManager.COMMON_DBNAME, "TopConversation");
    }

    /**
     * 保存的置顶会话用户
     */
    public static void saveTopConversation(Account account,List<String> topConversationUserName) {
        account.getPreferencesStoreManager().saveCacheByAccount(topConversationUserName, SharePreferencesManager.COMMON_DBNAME, "TopConversation");
    }

    /**
     * 获取免打扰的用户
     * @return
     */
    public static List getNotNotifyChatUsers(Account account) {
        return account.getPreferencesStoreManager().getCacheByAccount(List.class, SharePreferencesManager.COMMON_DBNAME, "NotNotifyChatUsers");
    }

    /**
     * 保存免打扰的用户
     */
    public static void saveNotNotifyChatUsers(Account account,List<String> userName) {
        account.getPreferencesStoreManager().saveCacheByAccount(userName, SharePreferencesManager.COMMON_DBNAME, "NotNotifyChatUsers");
    }

    /**
     * 获取免打扰的群组
     * @return
     */
    public static List getNotNotifyGroupChats(Account account) {
        return account.getPreferencesStoreManager().getCacheByAccount(List.class, SharePreferencesManager.COMMON_DBNAME, "NotNotifyGroupChats");
    }

    /**
     * 保存免打扰的群组
     */
    public static void saveNotNotifyGroupChats(Account account,List<String> groupName) {
        account.getPreferencesStoreManager().saveCacheByAccount(groupName, SharePreferencesManager.COMMON_DBNAME, "NotNotifyGroupChats");
    }

    /**
     * 获取发送消息的用户信息
     * @return
     */
    public static Map getUserInfoCache(Account account) {
        return account.getPreferencesStoreManager().getCacheByAccount(Map.class, SharePreferencesManager.COMMON_DBNAME, "UserInfoCache");
    }

    /**
     * 保存发送消息的用户信息
     */
    public static void saveUserInfoCache(Account account,Map<String, ContactInfoBean> groupName) {
        account.getPreferencesStoreManager().saveCacheByAccount(groupName, SharePreferencesManager.COMMON_DBNAME, "UserInfoCache");
    }

}
