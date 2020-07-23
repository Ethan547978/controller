package com.app.controller.config;

/**
 * 存储路径
 */
public class ConstantUrl {

    public static String DOMAIN_SELECT_NEW ;
    public static String COMMON ;
    public static String imageSource;

    private static ConstantUrl constantUrl;

    //H5分享使用
    public static String httpUrl = "";



    //恢复过的标记
    private static boolean recovered;

    /**
     * 检查对象的创建情况
     *
     * @return
     */
    public static boolean checkObjectExistence() {
        return constantUrl != null;
    }

    private ConstantUrl() {

    }

    public static ConstantUrl getInstance() {
        if (constantUrl == null) {
            synchronized (ConstantUrl.class) {
                //崩溃造成的登录信息恢复
                if (!recovered) {
                    recovered = true;
                }
                constantUrl = new ConstantUrl();
                return constantUrl;
            }
        } else
            return constantUrl;
    }

    public static void changeObject() {
        constantUrl = null;
        getInstance();
    }


    /**
     * 获得“热门”tab中的“焦点图”列表
     */
    public String getFocusTitleList = COMMON + "/getFocusTitleList";



}
