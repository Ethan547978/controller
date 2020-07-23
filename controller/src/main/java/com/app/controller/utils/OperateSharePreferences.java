package com.app.controller.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.controller.config.GloableParams;
import com.app.controller.CommonModule;
/**
 * 类 <code>OperateSharePreferences</code>
 */
public class OperateSharePreferences {
    private static final String SERVER_IP = "serverIp";
    private static final String LBS_IP = "lbsIp";
    private static final String SERVER_ID = "serverId";
    private static final String IMG_SOURCE = "imageSource";
    private static final String PERSONAL_PHOTO = "photoMine";
    private static final String SELECT_SERVER_INFO = "selectServerInfo";
    private static final String HTTP_URL = "httpurl-only";
    private static final String MOBILENET_ENABLE = "mobile_net_enable";
    private static final String PUSH_ENABLE = "user_system_live_push";
    private final String UID = "uid";
    private final String TAG = OperateSharePreferences.class.getSimpleName();
    /****************首选项文件名******************/
    /**
     * 存储用户信息文件名
     */
    private final String SP_FILE_XCBOBO = "xiaocaobobo";
    private static OperateSharePreferences my;
    private SharedPreferences mXcSharedPyreferences;
    private final String LOCATION_PROVINCE = "locationProvince";//定位的城市
    private final String SWITCH_PROVINCE = "switchProvince";//切换的城市
    private final String SWITCH_SEX = "sexSwitch";//切换 性别 1男 ,0女, 2全部
    private final String SYS_MESSAGE = "sysMessage";
    private final String USER_AMOUNT = "amount";//秀币，金币
    private final String LOGIN_DISTRICT = "login_district";//登录服务区
    private final String LOGIN_STYLE = "login_style";//登录方式
    private final String WECHAT_ACCESSTOKEN = "wechat_accessToken";//微信的access_token
    private final String WECHAT_ACCESS_DEADLINE = "wechat_access_deadLine";//微信的accessToken的过期时间
    private final String WECHAT_REFRESHTOKEN = "wechat_refreshToken";//微信的refreshToken
    private final String WECHAT_REFRESH_DEADLINE = "wechat_refresh_deadline";//微信的刷新token的过期时间
    private final String WECHAT_OPENID = "openid_wechat";
    private final String WECHAT_UNIONID = "unionId_wechat";
    private final String TOKEN = "token";
    private final String USERNAME = "username";
    private final String IDENTITY = "identity";//身份标识:1普通用户 2主播 3帮主 4助理
    private final String SID = "sid";
    private final String JOINED_GUILD = "joined_guild";//是否加入帮会的存储标志
    private final String LOGINKEY_IMGURL = "login_key_IMGURL";//登录需要用到的参数信息——登录用户头像地址
    private final String LOGINKEY_USERNAME = "login_key_USERNAME";//登录需要用到的参数信息——登录用户名
    private final String LOGINKEY_TYPE = "login_key_TYPE";//登录需要用到的参数信息_登录类型
    private final String LOGINKEY_USERID = "login_key_userId";//登录需要用到的参数信息_用户Id
    private final String GUILD_MSG_UNREAD_COUNT_INFORM = "guild_msg_unread_count_inform";//帮会通知未读消息数量
    private final String GUILD_MSG_UNREAD_COUNT_APPLY = "guild_msg_unread_count_apply";//帮会帮会申请未读消息数量
    private final String GUILD_INFORM_MSG_LAST_READ_ID = "guild_inform_msg_last_read_id";//最新阅读帮会通知消息的消息id
    private final String GUILD_APPLY_MSG_LAST_READ_ID = "guild_apply_msg_last_read_id";//最新阅读申请通知消息的消息id
    private final String DYNAMIC_WEIDU_NUM = "dynamic_weidu_num";//动态未读消息数

    private final String LIVE_MEIYAN = "live_meiyan";//直播美颜
    private final String LIVE_TITLE = "live_title";//直播标题

    public static final String EFFECTS_UPGRADE = "effects_upgrade";//战斗特效资源的版本
    public static final String EFFECTS_UPGRADE_PATH = "effects_upgrade_path";//战斗特效资源的路径
    public static final String EFFECTS_UPGRADE_COUNT = "effects_upgrade_count";//战斗特效资源的保存进度

    public static final String EFFECTS_UI_UPGRADE = "effects_ui_upgrade";//app的特效资源的版本
    public static final String EFFECTS_UI_UPGRADE_PATH = "effects_ui_upgrade_path";//app的特效资源的路径
    public static final String EFFECTS_UI_UPGRADE_COUNT = "effects_ui_upgrade_count";//app特效资源的保存进度
    //全局悬浮窗是否开启的标志位
    public static final String PERMISSION_FLOATING_STATUS = "isfloatingGlobal";

    //登录号码
    private final String PHONE_LOGIN_NUM = "phone_login_num";
    //登录密码
    private final String PHONE_LOGIN_PW = "phone_login_num";
    //最强新主播信息
    private final String BEST_NEW_ANCHOR_INFO = "best_new_anchor_info";

    //当前主播所有金币数
    private final String CURRENT_ANCHOR_GOLD_SUM = "current_anchor_gold_num";

    private OperateSharePreferences(Context context) {
        mXcSharedPyreferences = context.getSharedPreferences(SP_FILE_XCBOBO, Context.MODE_PRIVATE);
    }

    public static OperateSharePreferences getInstance() {
        if (my == null) {
            my = new OperateSharePreferences(CommonModule.getAppContext());
        }
        return my;
    }

    /**
     * 获取微信的access_token
     *
     * @return
     */
    public String getWechatAccessToken() {
        return mXcSharedPyreferences.getString(WECHAT_ACCESSTOKEN, null);
    }

    public void saveWechatAccessToken(String accessToken) {
        mXcSharedPyreferences.edit().putString(WECHAT_ACCESSTOKEN, accessToken).commit();
    }

    /**
     * 获取微信的refresh_token
     *
     * @return
     */
    public String getWechatRefreshToken() {
        return mXcSharedPyreferences.getString(WECHAT_ACCESSTOKEN, null);
    }

    public void saveWechatRefreshToken(String refreshToken) {
        mXcSharedPyreferences.edit().putString(WECHAT_REFRESHTOKEN, refreshToken).commit();
    }

    /**
     * 获取微信的access_token
     *
     * @return
     */
    public long getWechatAccessDeadLine() {
        return mXcSharedPyreferences.getLong(WECHAT_ACCESS_DEADLINE, -1);
    }

    public void saveWechatAccessDeadLine(long accessDeadLine) {
        mXcSharedPyreferences.edit().putLong(WECHAT_ACCESS_DEADLINE, accessDeadLine).commit();
    }

    /**
     * 获取微信的refresh_token
     *
     * @return
     */
    public long getWechatRefreshDeadLine() {
        return mXcSharedPyreferences.getLong(WECHAT_REFRESH_DEADLINE, -1);
    }

    public void saveWechatRefreshDeadLine(long refreshDeadLine) {
        mXcSharedPyreferences.edit().putLong(WECHAT_REFRESH_DEADLINE, refreshDeadLine).commit();
    }

    /**
     * 获得Openid
     *
     * @return
     */
    public String getWechatOpenId() {
        return mXcSharedPyreferences.getString(WECHAT_OPENID, null);
    }

    public void saveWechatOpenId(String openid) {
        mXcSharedPyreferences.edit().putString(WECHAT_OPENID, openid).commit();
    }

    /**
     * UnionId的获取方法
     *
     * @return
     */
    public String getWechatUnionId() {
        return mXcSharedPyreferences.getString(WECHAT_UNIONID, null);
    }

    public void saveWechatUnionId(String unionId) {
        mXcSharedPyreferences.edit().putString(WECHAT_UNIONID, unionId).commit();
    }

    /**
     * 保存用户的Uid !!!!!!!!已弃用
     *
     * @param uid
     */
    /*public void saveUid(String uid) {
        mXcSharedPyreferences.edit().putString(UID, uid).commit();
    }

    public String getUid() {
        return mXcSharedPyreferences.getString(UID, null);
    }*/

    /**
     * 保存用户的平台Token
     *
     * @param token
     */
    public void saveToken(String token) {
        mXcSharedPyreferences.edit().putString(TOKEN, token).commit();
    }

    public String getToken() {
        return mXcSharedPyreferences.getString(TOKEN, null);
    }

    /**
     * 保存用户的昵称
     *
     * @param username
     */
    public void saveNickname(String username) {
        GloableParams.NAME = username;
        mXcSharedPyreferences.edit().putString(USERNAME, username).commit();
    }

    public String getNickname() {
        return mXcSharedPyreferences.getString(USERNAME, null);
    }

    /**
     * 保持身份码
     *
     * @param identity
     */
    public boolean saveIdentity(int identity) {
        return mXcSharedPyreferences.edit().putInt(IDENTITY, identity).commit();
    }

    public void clearIdentity() {
        mXcSharedPyreferences.edit().remove(IDENTITY);
    }


    /**
     * 保存主播房间号的方法
     *
     * @param sid
     */
    public void saveSid(int sid) {
        mXcSharedPyreferences.edit().putInt(SID, sid).commit();
    }

    public int getSid() {
        return mXcSharedPyreferences.getInt(SID, -1);
    }

}

