package com.app.controller.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;


import com.app.library.utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * 存储公用数据,为有些界面能统一调用的公用方法
 */
public class GloableParams {

    public static int selectServerEnable;
    /**
     * 腾讯sdk是否初始化完成
     */
    public static boolean AV_READY = false;

    public static int IDENTITY_NORMAL_USER = 1;//普通用户
    public static int IDENTITY_ANCHOR = 2;// 2主播
    public static int IDENTITY_GUILP = 3;// 3帮主
    public static int IDENTITY_ASSISTEN = 4;//4助理

    /**
     * 用户Uid
     */
    public static String UID;
    public static String PHOTO;
    public static String NAME;
    public static String TOKEN;
    public static String AMOUNT = "0";//用户金币
    public static int SUN = 0;//用户阳光值
    public static int LEVEL = 0;//等级

    public static int getUid() {
        if (TextUtils.isEmpty(UID)) {
            return -1;
        } else {
            return Integer.valueOf(UID);
        }
    }


    /**
     * 保存登录数据
     */
    public static void saveLoginInfo(Context context, String info) {
        if (!TextUtils.isEmpty(info)) {
            try {
                JSONObject jsonObject = new JSONObject(info);
                GloableParams.AMOUNT = jsonObject.optString("amount");
//                OperateSharePreferences.getInstance().saveAmount(GloableParams.AMOUNT);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        SharedPreferences sp = context.getSharedPreferences("", Context.MODE_PRIVATE);
        Editor edit = sp.edit();
        edit.putString("UserInfo", info);
        edit.commit();
        if (!TextUtils.isEmpty(info)) {
            LogUtils.d("login", "保存登录信息成功 GlobalParams saveLoginInfo");
        } else {
            LogUtils.d("login", "GlobalParams saveLoginInfo 登录信息被洗掉");
        }
    }


    /**
     * 第三方登录存token的专用方法
     */
    public static void saveUserTokenForLoginWithOtherPlatforms(String token) {
//        OperateSharePreferences.getInstance().saveToken(token);
    }


    /**
     * 保存腾讯签名
     *
     * @param context
     * @param uid
     * @param sig
     */
    public static void saveAvSig(Context context, String uid, String sig) {
        SharedPreferences sp = context.getSharedPreferences("", Context.MODE_PRIVATE);
        Editor edit = sp.edit();
        edit.putString("AvSig_" + uid, sig);
        edit.commit();

    }

}
