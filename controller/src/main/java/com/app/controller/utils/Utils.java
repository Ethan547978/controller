package com.app.controller.utils;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.app.controller.account.Account;
import com.app.controller.account.AccountManager;
import com.app.library.utils.InfoUtil;
import com.app.library.utils.LogUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Utils {

    public static String getStringValue(Activity activity, int res){
        String string = null;
        try{
            string=activity.getResources().getString(res);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return string;
        }
    }

    public static int getColorValue(Activity activity, int res){
        int color=0;
        try{
            color=activity.getResources().getColor(res);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return color;
        }
    }

    /**
     * url加上传递参数
     */
    public static String setUrlParam(String url, Activity activity){
        Account account= AccountManager.getInstance().getLoginAccount();
        int channelCode=0;
        try{
            ApplicationInfo appInfo = activity.getPackageManager()
                    .getApplicationInfo(activity.getPackageName(), PackageManager.GET_META_DATA);
            channelCode=appInfo.metaData.getInt("CHANNEL_CODE");
        }catch (Throwable t){
            t.printStackTrace();
        }

        url+="&uid="+ account.getUid()
                +"&token="+account.getToken()
                //                +"&show_location="+showLocation
                +"&packageName="+ InfoUtil.getAppProcessName(activity)
                +"&version="+InfoUtil.getVersionName(activity)
                +"&channel="+ channelCode
                +"&clientType=2";
        return url;
    }

    // 通过文件头来判断是否gif
    public static boolean isGifByFile(File file) {
        try {
            int length = 10;
            InputStream is = new FileInputStream(file);
            byte[] data = new byte[length];
            is.read(data);
            String type = getType(data);
            is.close();

            if (type.equals("gif")) {
                return true;
            }
        } catch (Exception e) {
            LogUtils.v("isGifByFile", e.getMessage());
        }

        return false;
    }

    private static String getType(byte[] data) {
        String type = "";
        if (data[1] == 'P' && data[2] == 'N' && data[3] == 'G') {
            type = "png";
        } else if (data[0] == 'G' && data[1] == 'I' && data[2] == 'F') {
            type = "gif";
        } else if (data[6] == 'J' && data[7] == 'F' && data[8] == 'I'
                && data[9] == 'F') {
            type = "jpg";
        }
        return type;
    }
}
